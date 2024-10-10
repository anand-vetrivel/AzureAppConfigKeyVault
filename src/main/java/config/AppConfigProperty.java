package config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "config")
public class AppConfigProperty {
    private String reciprocityHost;

    public String getReciprocityHost() {
        return reciprocityHost;
    }

    public void setReciprocityHost(String reciprocityHost) {
        this.reciprocityHost = reciprocityHost;
    }

    @Override
    public String toString() {
        return "AppConfigProperty{" +
                "reciprocityHost=" + reciprocityHost +
                '}';
    }
}
