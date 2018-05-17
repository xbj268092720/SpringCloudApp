package com.example.feign.consumer.fallback;

import com.example.feign.consumer.client.ProviderClient;
import org.springframework.stereotype.Component;

/**
 * Created by cdwk-122 on 2018/4/16.
 */

@Component
public class ProviderFallBack implements ProviderClient {
    @Override
    public String consumer() {
        return "consumer 出问题了，服务被降级！";
    }

    @Override
    public String zuul() {
        return "consumer-zuul 出问题了，服务被降级！";
    }

}
