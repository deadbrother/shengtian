package com.shengtian.market.config.cors;

import org.springframework.web.cors.CorsConfiguration;

public class CorsConfig extends CorsConfiguration {
    private String path;

    public CorsConfig() {
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
