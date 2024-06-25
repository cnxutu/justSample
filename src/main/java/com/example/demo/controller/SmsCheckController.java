package com.example.demo.controller;

import com.example.demo.common.config.rsa.RSAEncrypted;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: xutu
 * @since: 2024/6/24 16:30
 */
@RequestMapping("/sms")
@RestController
public class SmsCheckController {


    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public String validate(
            @RequestParam("mobilePhone") String mobilePhone,
            @RequestParam("sensitiveData") @RSAEncrypted String sensitiveData) {


        return sensitiveData;
    }


}
