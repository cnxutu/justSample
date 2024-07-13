package com.example.demo5.common.config;

import com.example.demo5.common.constant.HeaderConstant;
import com.example.demo5.common.constant.UrlConstant;
import com.example.demo5.service.IWxbAuthService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author: xutu
 * @since: 2023/10/17 14:42
 */
public class WxbTokenInterceptor implements RequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(WxbTokenInterceptor.class);

    @Resource
    private IWxbAuthService loginService;


    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (this.isTokenUrl(requestTemplate)) {
            log.debug("is token request,url={}", requestTemplate.url());
        } else {
            log.debug("is not token request,url={}", requestTemplate.url());
            requestTemplate.header(HeaderConstant.AUTHORZATION, new String[]{loginService.getAccessToken()});
        }

    }

    private boolean isTokenUrl(RequestTemplate requestTemplate) {
        return requestTemplate.url().contains(UrlConstant.ACCESS_TOKEN_URL);
    }
}
