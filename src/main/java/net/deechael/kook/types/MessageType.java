package net.deechael.kook.types;

public enum MessageType {

    TEXT(1, "plain-text"),
    IMG(2, "image"),
    VIDEO(3, "video"),
    FILE(4, "file"),
    AUDIO(8, "audio"),
    KMD(9, "kmarkdown"),
    CARD(10, "cardmessage"),
    SYS(255, "system");

    private final int code;
    private final String name;

    MessageType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static MessageType of(int code) {
        switch (code) {
            case 1:
                return TEXT;
            case 2:
                return IMG;
            case 3:
                return VIDEO;
            case 4:
                return FILE;
            case 8:
                return AUDIO;
            case 9:
                return KMD;
            case 10:
                return CARD;
        }
        return SYS;
    }

}
