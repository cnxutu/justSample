package com.example.demo2.sms;

/**
 * @author: xutu
 * @since: 2024/6/28 20:26
 */
public class RegistrationSmsStrategy implements SmsStrategy {
    @Override
    public void sendSms(String phoneNumber, String message) {
        // 实现注册场景的短信发送逻辑
        System.out.println("Sending registration SMS to " + phoneNumber + ": " + message);
    }
}
