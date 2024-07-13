package com.example.demo5.service.impl;

import com.alibaba.fastjson2.JSON;
import com.example.demo5.api.WxbAccessTokenFeignApi;
import com.example.demo5.common.constant.HeaderConstant;
import com.example.demo5.common.constant.RedisConstant;
import com.example.demo5.common.constant.UrlConstant;
import com.example.demo5.pojo.query.WxbSdkQuery;
import com.example.demo5.pojo.response.RpcResult;
import com.example.demo5.service.IWxbAuthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: xutu
 * @since: 2023/10/17 10:40
 */
@Service
@Slf4j
public class WxbAuthServiceImpl implements IWxbAuthService {


    @Resource
    private WxbAccessTokenFeignApi accessTokenFeignApi;

    @Resource
    private RedissonClient redissonClient;

    @Value("${wxb.mobile}")
    private String mobilePhone;

    @Value("${wxb.appKey}")
    private String appKey;

    @Value("${wxb.appSecret}")
    private String appSecret;


    @Override
    public String getAccessToken() {
        log.debug("进行token获取 ...");
        RBucket<String> bucket = redissonClient.getBucket(RedisConstant.ACCESS_TOKEN);
        String accessToken = bucket.get();
        if (StringUtils.isNotBlank(accessToken)) {
            log.info("当前使用缓存中的token值为：{}", accessToken);
            return accessToken;
        }
        RLock rLock = redissonClient.getReadWriteLock(RedisConstant.ACCESS_TOKEN_LOCK).writeLock();
        boolean b = rLock.tryLock();
        String newAccessToken = null;
        if (b) {
            try {
                WxbSdkQuery wxbSdkQuery = new WxbSdkQuery();
                wxbSdkQuery.setMobile(mobilePhone);
                wxbSdkQuery.setAppKey(appKey);
                wxbSdkQuery.setAppSecret(appSecret);
                RpcResult<Map<String, String>> rpcResult = accessTokenFeignApi.getAccessToken(wxbSdkQuery);
                log.debug("请求wxb ===> 获取 sdk Token 接口返回的内容为：{}", JSON.toJSONString(rpcResult));
                if (rpcResult.getCode().equals(UrlConstant.REMOTE_QUERY_SUCCESS_CODE)) {
                    Map<String, String> data = rpcResult.getData();
                    String token = data.get("accessToken");
                    if (StringUtils.isNotEmpty(token)) {
                        newAccessToken = HeaderConstant.TOKEN_PREFIX + token;
                    }
                    bucket.set(newAccessToken, RedisConstant.ACCESS_TOKEN_EXPIRE_TIME, TimeUnit.DAYS);
                    log.info("当前的新token值为：{}", newAccessToken);
                } else {
                    log.debug("请求wxb ===> 获取 sdk Token 失败! ");
                }
            } catch (Exception e) {
                log.error("获取维小保 access_token 异常，异常信息为：{}", e);
            } finally {
                rLock.unlock();
            }
        }
        return newAccessToken;
    }

    @Override
    public String delToken() {
        RBucket<String> bucket = redissonClient.getBucket(RedisConstant.ACCESS_TOKEN);
        String accessToken = bucket.get();
        if (StringUtils.isNotEmpty(accessToken)) {
            bucket.delete();
        }
        return "SUCCESS!";
    }


}
