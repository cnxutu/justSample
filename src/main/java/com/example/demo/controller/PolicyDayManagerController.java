package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.config.ThirdPropertyConfiguration;
import com.example.demo.pojo.po.PolicyDayManagerPO;
import com.example.demo.service.IPolicyDayManagerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xutu
 * @since 2023-09-19
 */
@RestController
@RequestMapping("/policyDayManager")
public class PolicyDayManagerController {

    @Resource
    private IPolicyDayManagerService policyDayManagerService;

    @Resource
    private ThirdPropertyConfiguration propertyConfiguration;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<PolicyDayManagerPO> list(@RequestParam("sharding") Integer sharding) {
        LambdaQueryWrapper<PolicyDayManagerPO> eq = Wrappers.<PolicyDayManagerPO>lambdaQuery()
                .eq(PolicyDayManagerPO::getSharding, sharding);
        List<PolicyDayManagerPO> list = policyDayManagerService.list(eq);
        return list.stream().limit(100).collect(Collectors.toList());
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        String str = "ios维保appId" + propertyConfiguration.getIosWbWechatAppId() + "-" +
                "ios维保appSecret" + propertyConfiguration.getIosWyWechatAppSecret() + "-" +
                "adroid维保appId" + propertyConfiguration.getAdroidWbWechatAppId() + "-" +
                "adroid维保appSecret" + propertyConfiguration.getAdroidWyWechatAppSecret();
        return str;
    }


}
