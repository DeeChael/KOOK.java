package net.deechael.kook.api;

import com.google.gson.JsonObject;
import net.deechael.kook.content.Content;
import net.deechael.kook.types.ChannelType;
import net.deechael.kook.types.MessageType;

public interface RawMessage {

    MessageType getType();

    ChannelType getChannelType();

    String getTargetId();

    String getAuthorId();

    Content getContent();

    String getId();

    long getTimestamp();

    String getNonce();

    JsonObject getExtra();

}
