package com.example.demo2.sms;

public interface SmsStrategy {
    void sendSms(String phoneNumber, String message);
}

