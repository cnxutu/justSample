package com.example.demo.controller;

import com.example.demo.common.config.rsa.annotion.RSAEncryptedParam;
import com.example.demo.common.config.rsa.query.RsaQuery;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam("sensitiveData") @RSAEncryptedParam String sensitiveData) {


        return sensitiveData;
    }


    @RequestMapping(value = "/validateBody", method = RequestMethod.POST)
    public String validateBody(@RequestBody RsaQuery rsaQuery) {


        return rsaQuery.toString();
    }



}
