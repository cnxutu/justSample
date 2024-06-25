package com.example.demo.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: xutu
 * @since: 2024/1/5 16:15
 */
@Component
@Data
public class ThirdPropertyConfiguration {

    @Value("${third.ios.wb.wechat.appId}")
    private String iosWbWechatAppId;

    @Value("${third.ios.wy.wechat.appSecret}")
    private String iosWyWechatAppSecret;

    @Value("${third.adroid.wb.wechat.appId}")
    private String adroidWbWechatAppId;

    @Value("${third.adroid.wy.wechat.appSecret}")
    private String adroidWyWechatAppSecret;

}
