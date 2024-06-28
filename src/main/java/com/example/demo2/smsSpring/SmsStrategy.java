package com.example.demo2.smsSpring;

public interface SmsStrategy {
    void sendSms(String phoneNumber, String message);

    String getStrategyType();

}
