package net.deechael.kook.api;

public interface Bot {

    void start();

    void shutdown();

    User me();

    Client getClient();

}
