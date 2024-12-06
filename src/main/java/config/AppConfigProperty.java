package config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "config")
public class AppConfigProperty {
    private String demoName;

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    @Override
    public String toString() {
        return "AppConfigProperty{" +
                "demoName='" + demoName + '\'' +
                '}';
    }
}
