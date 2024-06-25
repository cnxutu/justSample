package com.example.demo.common.config.rsa.annotion;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: xutu
 * @since: 2024/6/25 10:03
 */
//@Target(ElementType.PARAMETER)
//@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RSAEncrypted {
}
