package net.deechael.kook.network;

public class Route {

    private final String method;

    private final String route;

    public Route(String method, String url) {
        this.method = method;
        this.route = url;
    }

    public String getMethod() {
        return method;
    }

    public String getRoute() {
        return route;
    }

}
