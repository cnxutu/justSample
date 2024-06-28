package com.example.demo2.sms;

/**
 * @author: xutu
 * @since: 2024/6/28 20:28
 */
public class SmsClient {

    /**
     * 1. 定义短信发送策略接口 SmsStrategy
     * 2. 实现具体的短信发送策略 RegistrationSmsStrategy & PasswordResetSmsStrategy
     *      假设我们有两个场景：注册和密码重置。
     * 3. 创建一个上下文类 SmsContext
     * 4. 通用短信发送接口 SmsService
     * 5. 使用示例 SmsClient
     * @param args
     */

    public static void main(String[] args) {

        SmsService smsService = new SmsService();

        // 发送注册短信
        smsService.sendSms("1234567890", "Welcome to our service!", SmsService.SmsType.REGISTRATION);

        // 发送密码重置短信
        smsService.sendSms("1234567890", "Your password reset code is 123456.", SmsService.SmsType.PASSWORD_RESET);
    }
}
