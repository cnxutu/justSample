package com.example.demo5.api;

import com.xzl.wxbserver.common.config.WxbMallFeignConfig;
import com.xzl.wxbserver.pojo.query.WxbSdkQuery;
import com.xzl.wxbserver.pojo.response.RpcResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author: xutu
 * @since: 2023/10/14 17:52
 * @desc: 调用wxb获取token相关api接口
 */
@FeignClient(name = "wxbServer-Auth", contextId = "wxb-server-token-mall-to-auth", url = "${wxb.apiUrl}", configuration = WxbMallFeignConfig.class, path = "auth-server")
public interface WxbAccessTokenFeignApi {

    @RequestMapping(value = "/auth/sdk/accessToken", method = RequestMethod.POST)
    RpcResult<Map<String, String>> getAccessToken(@RequestBody WxbSdkQuery wxbSdkQuery);


}
