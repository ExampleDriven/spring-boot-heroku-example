package org.exampledriven;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "worker")
public class WorkerConfig {

    String scheme;
    String host;
    int port;

    public String getHost() {
        return host;
    }

    public String getURL() {
        return getScheme() + "://" + getHost() + ":" + getPort();
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

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
}
