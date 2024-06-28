package com.example.demo2.smsSpring;

import org.springframework.stereotype.Component;

/**
 * @author: xutu
 * @since: 2024/6/28 20:35
 */
@Component
public class RegistrationSmsStrategy implements SmsStrategy {
    @Override
    public void sendSms(String phoneNumber, String message) {
        // 实现注册场景的短信发送逻辑
        System.out.println("Sending registration SMS to " + phoneNumber + ": " + message);
    }

    @Override
    public String getStrategyType() {
        return "REGISTRATION";
    }

}