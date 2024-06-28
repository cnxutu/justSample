package com.example.demo2.sms;

/**
 * @author: xutu
 * @since: 2024/6/28 20:27
 */
public class SmsContext {

    private SmsStrategy strategy;

    public SmsContext(SmsStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SmsStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendSms(String phoneNumber, String message) {
        strategy.sendSms(phoneNumber, message);
    }
}
