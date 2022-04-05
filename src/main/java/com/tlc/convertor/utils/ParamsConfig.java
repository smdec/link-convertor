package com.tlc.convertor.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Represent configurable parameters for converting links, see application.yml
 */
@Component
@ConfigurationProperties(prefix = "params")
public class ParamsConfig {
    private Map<String, String> deeplinks;
    private Map<String, String> weblinks;

    public Map<String, String> getDeeplinks() {
        return deeplinks;
    }

    public void setDeeplinks(Map<String, String> deeplinks) {
        this.deeplinks = deeplinks;
    }

    public Map<String, String> getWeblinks() {
        return weblinks;
    }

    public void setWeblinks(Map<String, String> weblinks) {
        this.weblinks = weblinks;
    }
}
