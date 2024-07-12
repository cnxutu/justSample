package com.example.demo5.common.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xutu
 * @since: 2024/4/23 20:21
 */
@Configuration
public class WxbMallFeignConfig {

    @Bean
    public RequestInterceptor wxbTokenInterceptor() {
        return new WxbTokenInterceptor();
    }

}
