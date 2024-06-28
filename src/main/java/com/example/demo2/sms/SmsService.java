package com.example.demo2.sms;

public class SmsService {
    private SmsContext smsContext;

    public SmsService() {
        // 初始化时可以设置一个默认策略
        this.smsContext = new SmsContext(new RegistrationSmsStrategy());
    }

    public void sendSms(String phoneNumber, String message, SmsType type) {
        // 根据不同的类型设置不同的策略
        switch (type) {
            case REGISTRATION:
                smsContext.setStrategy(new RegistrationSmsStrategy());
                break;
            case PASSWORD_RESET:
                smsContext.setStrategy(new PasswordResetSmsStrategy());
                break;
            // 可以根据需要添加更多的策略
            default:
                throw new IllegalArgumentException("Unknown SMS type: " + type);
        }

        // 发送短信
        smsContext.sendSms(phoneNumber, message);
    }

    // 定义枚举类型来表示不同的短信场景
    public enum SmsType {
        REGISTRATION,
        PASSWORD_RESET
        // 其他类型
    }

}
