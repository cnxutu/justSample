package com.example.demo.common.config.rsa.query;

import com.example.demo.common.config.rsa.annotion.RSAEncrypted;
import lombok.Data;

/**
 * @author: xutu
 * @since: 2024/6/25 9:36
 */
@Data
public class RsaQuery {

    @RSAEncrypted
    private String sensitiveData;

    private String mobilePhone;


}
