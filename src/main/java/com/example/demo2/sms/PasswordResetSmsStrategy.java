package com.example.demo2.sms;

/**
 * @author: xutu
 * @since: 2024/6/28 20:27
 */
public class PasswordResetSmsStrategy implements SmsStrategy {
    @Override
    public void sendSms(String phoneNumber, String message) {
        // 实现密码重置场景的短信发送逻辑
        System.out.println("Sending password reset SMS to " + phoneNumber + ": " + message);
    }
}