package org.apache.pluto.maven;

import java.util.List;
import java.io.File;

/**
 *
 */
public class ServerConfig {

    private String domain = "MyDomain";
    private String server = "MyServer";
    private String host = "localhost";
    private int port = 8080;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
