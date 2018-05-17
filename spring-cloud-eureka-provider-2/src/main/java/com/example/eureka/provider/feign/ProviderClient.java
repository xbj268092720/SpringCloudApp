package com.example.eureka.provider.feign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by cdwk-122 on 2018/4/16.
 */

@FeignClient(value = "feign-consumer")
public interface ProviderClient {

    @GetMapping("/zuul3")
    public String provider();
}
