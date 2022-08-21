import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.NonNull;
import net.deechael.kook.API;
import okhttp3.*;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        String a = "aaa";
        System.out.println(a.substring(0, 0));
        System.out.println(a.substring(0, 1));
        //Call call = new OkHttpClient.Builder().build().newCall(new Request.Builder()
        //        .get()
        //        .header("Authorization", "Bot token")
        //        .header("Content-type", "application/json")
        //        .url(API.BASE_URL + API.V3.Gateway.index().getRoute() + "?compress=1").build());
        //call.enqueue(new Callback() {
        //    @Override
        //    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        //        System.out.println("Failed to fetch the gateway websocket url");
        //    }
//
        //    @Override
        //    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        //        JsonObject body = JsonParser.parseString(response.body().string()).getAsJsonObject();
        //        String url = body.getAsJsonObject("data").get("url").getAsString();
        //        System.out.println("Gateway websocket url: " + url);
        //    }
        //});
    }

}
