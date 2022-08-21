package net.deechael.kook.types;

public enum ChannelType {

    GROUP("GROUP"),
    PERSON("PERSON"),
    BROADCAST("BROADCAST");

    private final String name;

    ChannelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
