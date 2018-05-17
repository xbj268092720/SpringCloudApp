package com.example.eureka.provider.controller;

import com.example.eureka.provider.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cdwk-122 on 2018/4/16.
 */

@RestController
@RefreshScope
public class ProviderController {
    @Value("${content}")
    String content;

    @Value("${server.port}")
    String port;

    @Autowired
    private ProviderClient providerClient;

    @RequestMapping("/")
    public String home() {
        System.out.println("Hello world ,port:" + port+",content="+content);
        return "Hello world ,port:" + port+",content="+content;
    }
    @RequestMapping("/zuul2")
    public String zuul() {
        System.out.println("zuul2");
        String result = providerClient.provider();
        result += "--> Hello world ,port:" + port+",content="+content;
        return result;
    }
}
