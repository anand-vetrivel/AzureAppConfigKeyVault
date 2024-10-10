package controller;

import config.AppConfigProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
    private final AppConfigProperty properties;

    public DemoRestController(AppConfigProperty properties) {
        this.properties = properties;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String readAppConfigValue() {
        System.out.println("Inside readAppConfigValue() !");
        return properties.toString();
    }
}
