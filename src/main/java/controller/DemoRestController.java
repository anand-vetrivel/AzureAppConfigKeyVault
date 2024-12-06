package controller;

import config.AppConfigProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @Value("${demo-key}")
    private String demoKey;

    private final AppConfigProperty properties;

    public DemoRestController(AppConfigProperty properties) {
        this.properties = properties;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String readAppConfigValue() {
        System.out.println("Inside readAppConfigValue() !");
        return ">>>>>>>>>>>> APP CONFIG values = " + properties.toString() + ", >>>>>>>>>>>> KEY VAULT value demoKey = " + demoKey;
    }
}
