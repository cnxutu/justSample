package com.example.demo4;

/**
 * @author: xutu
 * @since: 2024/7/4 00:23
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final ServiceAFeignClient serviceAFeignClient;
    private final ServiceBFeignClient serviceBFeignClient;

    @Autowired
    public ApiController(ServiceAFeignClient serviceAFeignClient, ServiceBFeignClient serviceBFeignClient) {
        this.serviceAFeignClient = serviceAFeignClient;
        this.serviceBFeignClient = serviceBFeignClient;
    }

    @GetMapping("/callServiceA")
    public String callServiceA(@RequestParam String specificParam) {
        return serviceAFeignClient.callServiceAEndpoint(specificParam);
    }

    @GetMapping("/callServiceB")
    public String callServiceB(@RequestParam String differentParam) {
        return serviceBFeignClient.callServiceBEndpoint(differentParam);
    }
}