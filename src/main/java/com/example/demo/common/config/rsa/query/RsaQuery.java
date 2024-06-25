package com.example.demo.common.config.rsa.query;

import com.example.demo.common.config.rsa.RSAEncrypted;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: xutu
 * @since: 2024/6/25 9:36
 */
@Data
public class RsaQuery {

    private String mobilePhone;

//    @RSAEncrypted
    private String sensitiveData;


}
