package com.example.demo2.smsSpring;

/**
 * @author: xutu
 * @since: 2024/6/28 20:36
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SmsClient implements CommandLineRunner {

    private final SmsService smsService;

    @Autowired
    public SmsClient(SmsService smsService) {
        this.smsService = smsService;
    }


    /**
     * 1. 策略实现类：使用@Component注解标记策略实现类，并指定bean的名称。例如，@Component("registrationSmsStrategy")表示这个bean的名称是registrationSmsStrategy。
     * 2. 自动注入Map：在SmsService类中，使用@Autowired注解将所有实现了SmsStrategy接口的bean注入到Map<String, SmsStrategy>中。Spring会自动将这些bean按照它们的名称注入到Map中，key是bean的名称，value是bean的实例。
     * 3. 通过枚举类型选择策略：在SmsService类中，通过枚举类型的getStrategyBeanName()方法获取策略的bean名称，然后从smsStrategyMap中获取对应的策略实例，并调用sendSms方法。
     * 4. 通过这种方式，Spring会自动初始化smsStrategyMap，并将所有策略实现类注入到其中，使得代码更加灵活和可维护。
     * @param args
     */
    @Override
    public void run(String... args) {
        // 发送注册短信
        smsService.sendSms("1234567890", "Welcome to our service!", SmsService.SmsType.REGISTRATION);

        // 发送密码重置短信
        smsService.sendSms("1234567890", "Your password reset code is 123456.", SmsService.SmsType.PASSWORD_RESET);
    }
}