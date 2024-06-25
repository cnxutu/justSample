package com.example.demo.common.config.rsa;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author: xutu
 * @since: 2024/6/24 19:45
 */
@Aspect
@Component
//@Order(1)
public class RSADecryptionAspect {

    @Resource
    private RSAKeyConfig config;


    @Before("execution(* com.example..*(..)) && args(mobilePhone, @RSAEncrypted b)")
    public void beforeMethod(JoinPoint joinPoint, String mobilePhone, String b) {
        System.out.println("Parameter a: " + mobilePhone);
        System.out.println("Parameter b: " + b);
    }


    @Around("execution(* com.example..*(..))")
    public Object decryptRSAEncryptedParameters(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();

        String decryptedValue = null;
        String comparisonValue = null;
        Parameter[] parameters = method.getParameters();

        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].isAnnotationPresent(RSAEncrypted.class)) {
                String encryptedValue = (String) args[i];
                if (encryptedValue != null) {
                    decryptedValue = RSAUtil.decryptStr(encryptedValue, config.getPrivateKey());
                    args[i] = decryptedValue; // replace encrypted value with decrypted value
                }
            } else if (RSAUtil.COMPARISON_NAME.equals(parameters[i].getName())) {
                comparisonValue = (String) args[i];
            }
        }
        // Compare decrypted value with parameter b
        if (decryptedValue != null && comparisonValue != null && !decryptedValue.equals(comparisonValue)) {
            throw new IllegalArgumentException("Decrypted value does not match parameter b");
        }
        return joinPoint.proceed(args);
    }

}
