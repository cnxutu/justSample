package com.example.demo4;

/**
 * @author: xutu
 * @since: 2024/7/4 00:21
 */
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthFeignInterceptor implements RequestInterceptor {

    private final AuthService authService;

    public AuthFeignInterceptor(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获取Token
        String token = authService.getToken();
        // 添加Token到请求头
        requestTemplate.header("Authorization", "Bearer " + token);
    }
}
