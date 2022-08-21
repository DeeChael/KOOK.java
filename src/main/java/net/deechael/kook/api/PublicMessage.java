package net.deechael.kook.api;

import net.deechael.kook.content.Content;

public interface PublicMessage extends Message {

    void reply(Content content, boolean quote, boolean isTemp);

}
