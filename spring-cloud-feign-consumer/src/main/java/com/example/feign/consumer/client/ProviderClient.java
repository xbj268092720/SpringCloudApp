package com.example.feign.consumer.client;

//import org.springframework.cloud.netflix.feign.FeignClient;

import com.example.feign.consumer.fallback.ProviderFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述: 指定这个接口所要调用的 提供者服务名称 "eureka-provider"
 *
 * @author yanpenglei
 * @create 2017-12-06 15:13
 **/

@FeignClient(value = "eureka-provider",fallback = ProviderFallBack.class)
public interface  ProviderClient {

    // 可以增加前缀来路由到不同服务
    @GetMapping("/")
    String consumer();

    @GetMapping("/zuul2")
    String zuul();
}
