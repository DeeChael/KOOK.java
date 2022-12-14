package net.deechael.kook.impl;

import com.google.gson.JsonObject;
import lombok.Getter;
import net.deechael.kook.api.RawMessage;
import net.deechael.kook.content.Content;
import net.deechael.kook.content.StringContent;
import net.deechael.kook.gate.Gateway;
import net.deechael.kook.types.ChannelType;
import net.deechael.kook.types.MessageType;

public abstract class RawMessageImpl implements RawMessage {

    @Getter
    private MessageType type;
    @Getter
    private ChannelType channelType;
    @Getter
    private String targetId;
    @Getter
    private String authorId;
    @Getter
    private Content content;
    @Getter
    private String id;
    @Getter
    private long timestamp;
    @Getter
    private String nonce;
    @Getter
    private JsonObject extra;

    private Gateway gateway;

    public RawMessageImpl(Gateway gateway, JsonObject object) {
        this.gateway = gateway;
        this.type = MessageType.of(object.get("type").getAsInt());
        this.channelType = ChannelType.valueOf(object.get("channel_type").getAsString());
        this.targetId = object.get("target_id").getAsString();
        this.authorId = object.get("author_id").getAsString();
        this.content = this.type == MessageType.CARD ? null : new StringContent(object.get("content").getAsString());
        this.id = object.get("msg_id").getAsString();
        this.timestamp = object.get("msg_timestamp").getAsLong();
        this.nonce = object.get("nonce").getAsString();
        this.extra = object.getAsJsonObject("extra");
    }

    public Gateway getGateway() {
        return gateway;
    }

}
