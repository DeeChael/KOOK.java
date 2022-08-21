package net.deechael.kook.impl;

import com.google.gson.JsonObject;
import lombok.Getter;
import net.deechael.kook.api.Message;
import net.deechael.kook.api.User;
import net.deechael.kook.gate.Gateway;

public abstract class MessageImpl extends RawMessageImpl implements Message {

    @Getter
    private User author;

    public MessageImpl(Gateway gateway, JsonObject object) {
        super(gateway, object);
        // TODO: author = new User();
    }

}
