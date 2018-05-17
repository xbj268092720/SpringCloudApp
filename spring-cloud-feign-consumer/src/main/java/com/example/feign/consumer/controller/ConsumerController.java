package com.example.feign.consumer.controller;

import com.example.feign.consumer.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:调用提供者的 `home` 方法
 *
 * @author yanpenglei
 * @create 2017-12-06 15:26
 **/
@RestController
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;


    @GetMapping(value = "/hello")
    public String hello() {
        String result = providerClient.consumer();
        return  result;
    }

    @GetMapping(value = "/zuul1")
    public String zuul() {
        return  providerClient.zuul();
    }

    @GetMapping(value = "/zuul3")
    public String back() {
        return  "back";
    }
}
