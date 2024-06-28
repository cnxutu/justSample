package com.example.demo2.smsSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: xutu
 * @since: 2024/6/28 20:36
 */
@Service
public class SmsService {
    private final List<SmsStrategy> smsStrategyList;
    private final Map<String, SmsStrategy> smsStrategyMap;


// 单独注入List
//    @Autowired
//    public SmsService(List<SmsStrategy> smsStrategyList) {
//        this.smsStrategyList = smsStrategyList;
//    }
// 单独注入Map
//    @Autowired
//    public SmsService(Map<String, SmsStrategy> smsStrategyMap) {
//        this.smsStrategyMap = smsStrategyMap;
//    }

    /**
     * 同时注入到List和Map中
     * @param smsStrategyList
     * @param smsStrategyMap
     */
    @Autowired
    public SmsService(List<SmsStrategy> smsStrategyList, Map<String, SmsStrategy> smsStrategyMap) {
        this.smsStrategyList = smsStrategyList;
        this.smsStrategyMap = smsStrategyMap;
    }

    public void sendSms(String phoneNumber, String message, SmsType type) {
        // 通过List查找策略
        SmsStrategy strategyFromList = smsStrategyList.stream()
                .filter(s -> s.getStrategyType().equals(type.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown SMS type: " + type));
        strategyFromList.sendSms(phoneNumber, message);

        // 通过Map查找策略
        SmsStrategy strategyFromMap = smsStrategyMap.get(type.getStrategyBeanName());
        if (strategyFromMap != null) {
            strategyFromMap.sendSms(phoneNumber, message);
        } else {
            throw new IllegalArgumentException("Unknown SMS type: " + type);
        }
    }

    public enum SmsType {
        REGISTRATION("registrationSmsStrategy"),
        PASSWORD_RESET("passwordResetSmsStrategy");

        private final String strategyBeanName;

        SmsType(String strategyBeanName) {
            this.strategyBeanName = strategyBeanName;
        }

        public String getStrategyBeanName() {
            return strategyBeanName;
        }
    }


}
