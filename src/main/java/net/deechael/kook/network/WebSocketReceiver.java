package net.deechael.kook.network;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.NonNull;
import net.deechael.kook.API;
import net.deechael.kook.utils.NetworkUtils;
import okhttp3.*;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WebSocketReceiver extends Receiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketReceiver.class);

    private PacketListener listener = new PacketListener(this);
    private WebSocket webSocket;
    private boolean helloReceived = false;
    private long startTime = 0L;

    public WebSocketReceiver(OkHttpClient client, String token) {
        super(client, token);
    }

    @Override
    public void start() {
        this.helloReceived = false;
        this.startTime = 0L;
        Call call = getClient().newCall(new Request.Builder()
                .get()
                .header("Authorization", "Bot " + getToken())
                .header("Content-type", "application/json")
                .url(API.BASE_URL + API.V3.Gateway.index().getRoute() + "?compress=1").build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                LOGGER.error("Failed to fetch the gateway websocket url");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                LOGGER.debug("Fetched gateway websocket url successfully");
                JsonObject body = JsonParser.parseString(response.body().string()).getAsJsonObject();
                String url = body.getAsJsonObject("data").get("url").getAsString();
                LOGGER.debug("Gateway websocket url: " + url);
                WebSocketReceiver.this.startTime = System.currentTimeMillis();
                WebSocketReceiver.this.startWebSocket(url + "&resume=1");
            }
        });
    }

    private void reconnect(int sn, String session_id) {
        this.helloReceived = false;
        this.startTime = 0L;
        Call call = getClient().newCall(new Request.Builder()
                .get()
                .header("Authorization", "Bot " + getToken())
                .header("Content-type", "application/json")
                .url(API.BASE_URL + API.V3.Gateway.index().getRoute() + "?compress=1").build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                LOGGER.error("Failed to fetch the gateway websocket url");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                LOGGER.debug("Fetched gateway websocket url successfully");
                JsonObject body = JsonParser.parseString(response.body().string()).getAsJsonObject();
                String url = body.getAsJsonObject("data").get("url").getAsString();
                LOGGER.debug("Gateway websocket url: " + url);
                WebSocketReceiver.this.startTime = System.currentTimeMillis();
                WebSocketReceiver.this.startWebSocket(url + "&resume=1&sn" + sn + "&session_id=" + session_id);
            }
        });
    }

    private void startWebSocket(String url) {
        LOGGER.debug("Starting websocket...");
        this.webSocket = getClient().newWebSocket(new Request.Builder().get().url(url).build(), this.listener);
    }

    private void receive(JsonObject signaling) {
        int id = signaling.get("s").getAsInt();
        switch (id) {
            case 0:
                this.listener.sn = signaling.get("sn").getAsInt();
                break;
            case 1:
                int code = signaling.getAsJsonObject("d").get("code").getAsInt();
                if (code == 0) {
                    this.helloReceived = true;
                    this.startTime = 0L;
                    this.listener.session_id = signaling.getAsJsonObject("d").get("session_id" +
                            "").getAsString();
                } else if (code == 40100) {
                    LOGGER.error("Cannot connect to websocket because the required parameters are missed");
                } else if (code == 40101) {
                    LOGGER.error("Invalid token");
                } else if (code == 40102) {
                    LOGGER.error("Failed to verify the token");
                } else if (code == 40103) {
                    LOGGER.error("The token was expired");
                } else {
                    LOGGER.error("Error with unknown code: " + code);
                }
                break;
        }
    }

    private void interruptWithoutHello() {
        LOGGER.error("Didn't receive hello packet, connected to websocket failed");
    }

    private static final class PacketListener extends WebSocketListener {

        private final WebSocketReceiver receiver;

        private int sn = -1;
        private String session_id = "";

        public PacketListener(WebSocketReceiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
            LOGGER.debug("Connected successfully");
        }

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
            this.receiver.receive(JsonParser.parseString(text).getAsJsonObject());
        }

        @Override
        public void onMessage(@NotNull WebSocket webSocket, @NotNull ByteString bytes) {
            this.onMessage(webSocket, NetworkUtils.byteString2String(bytes));
        }

        @Override
        public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
            LOGGER.debug("WebSocket connection has been closed");
            if (code == 233 && reason.equalsIgnoreCase("kook.java"))
                return;
            LOGGER.debug("Trying to reconnect");
            this.receiver.reconnect(this.sn, this.session_id);
        }

        @Override
        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable throwable, Response response) {
            LOGGER.debug("Failed to connect to websocket");
        }

    }

}
