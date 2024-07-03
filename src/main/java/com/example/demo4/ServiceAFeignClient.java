package com.example.demo4;

/**
 * @author: xutu
 * @since: 2024/7/4 00:22
 */
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "serviceA", url = "https://api.serviceA.com", configuration = AuthFeignInterceptor.class)
public interface ServiceAFeignClient {

    @GetMapping("/getToken")
    String getToken(@RequestHeader("ak") String ak, @RequestHeader("sk") String sk);

    @GetMapping("/someEndpoint")
    String callServiceAEndpoint(@RequestHeader("Authorization") String token, @RequestParam("specificParam") String specificParam);
}