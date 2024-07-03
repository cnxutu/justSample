package com.example.demo4;

/**
 * @author: xutu
 * @since: 2024/7/4 00:21
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Value("${api.services.serviceA.ak}")
    private String serviceAAk;

    @Value("${api.services.serviceA.sk}")
    private String serviceASk;

    @Value("${api.services.serviceB.ak}")
    private String serviceBAk;

    @Value("${api.services.serviceB.sk}")
    private String serviceBSk;

    private final ServiceAFeignClient serviceAFeignClient;
    private final ServiceBFeignClient serviceBFeignClient;

    public AuthService(ServiceAFeignClient serviceAFeignClient, ServiceBFeignClient serviceBFeignClient) {
        this.serviceAFeignClient = serviceAFeignClient;
        this.serviceBFeignClient = serviceBFeignClient;
    }

    public String getToken() {
        // 根据具体的需求获取Token，示例中选择ServiceA的Token
        return serviceAFeignClient.getToken(serviceAAk, serviceASk);
    }
}
