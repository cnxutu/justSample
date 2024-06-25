package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.pojo.po.PolicyDayManagerPO;
import com.example.demo.pojo.po.PolicyWeekManagerPO;
import com.example.demo.service.IPolicyWeekManagerService;
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
 *  前端控制器
 * </p>
 *
 * @author xutu
 * @since 2023-09-19
 */
@RestController
@RequestMapping("/policyWeekManager")
public class PolicyWeekManagerController {

    @Resource
    private IPolicyWeekManagerService policyWeekManagerService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<PolicyWeekManagerPO> list(@RequestParam("unitMasterId") Integer unitMasterId){
        LambdaQueryWrapper<PolicyWeekManagerPO> eq = Wrappers.<PolicyWeekManagerPO>lambdaQuery()
                .eq(PolicyWeekManagerPO::getUnitMasterId, unitMasterId);
        List<PolicyWeekManagerPO> list = policyWeekManagerService.list(eq);
        return list.stream().limit(100).collect(Collectors.toList());
    }

}
