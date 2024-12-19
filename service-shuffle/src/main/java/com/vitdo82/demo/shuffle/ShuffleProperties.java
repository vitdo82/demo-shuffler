package com.vitdo82.demo.shuffle;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("shuffle")
public class ShuffleProperties {

    private String logUrl;

    public ShuffleProperties() {
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getLogUrl() {
        return logUrl;
    }
}
