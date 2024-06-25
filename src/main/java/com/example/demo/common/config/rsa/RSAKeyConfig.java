package com.example.demo.common.config.rsa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PrivateKey;

/**
 * @author: xutu
 * @since: 2024/6/24 15:07
 */
@Configuration
public class RSAKeyConfig {

    @Value("${sms-verification.privatekey}")
    private String rsaPrivateKey;

    public PrivateKey getPrivateKey() {
        PrivateKey privateKeyFromBase64 = null;
        try {
            privateKeyFromBase64 = RSAUtil.getPrivateKeyFromBase64(rsaPrivateKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return privateKeyFromBase64;
    }


}
