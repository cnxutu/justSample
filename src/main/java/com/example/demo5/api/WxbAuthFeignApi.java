package com.example.demo5.api;


import com.example.demo5.common.config.WxbMallFeignConfig;
import com.example.demo5.pojo.dto.IdAuthDTO;
import com.example.demo5.pojo.dto.PlotLiftPageDTO;
import com.example.demo5.pojo.dto.UnitMaintLiftStatDTO;
import com.example.demo5.pojo.dto.UnitVerifyDTO;
import com.example.demo5.pojo.query.PlotLiftQuery;
import com.example.demo5.pojo.query.UnitLiftStatQuery;
import com.example.demo5.pojo.response.Pager;
import com.example.demo5.pojo.response.RpcResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author: xutu
 * @since: 2023/10/14 17:52
 * @desc: 调用 wxb-auth 服务获取相关业务数据
 */
@FeignClient(name = "wxbServer-Auth", contextId = "wxb-server-mall-to-auth", url = "${wxb.apiUrl}", configuration = WxbMallFeignConfig.class, path = "auth-server")
public interface WxbAuthFeignApi {

    //***************************************** 用户相关 *****************************************

    @RequestMapping(value = "/api/user/getUserPwdByPhone", method = RequestMethod.GET)
    public RpcResult<String> getUserPwdByPhone(@RequestParam("mobilePhone") String mobilePhone);



    //***************************************** 电梯相关 *****************************************
    @RequestMapping(value = "/api/lift/plotLiftPageList", method = RequestMethod.POST)
    public RpcResult<Pager<PlotLiftPageDTO>> plotLiftPageList(@RequestBody PlotLiftQuery query);




    //***************************************** 单位相关 *****************************************

    @RequestMapping(value = "/api/unit/getUnitVerifyInfoByUnitIdList", method = RequestMethod.POST)
    public RpcResult<List<UnitVerifyDTO>> getUnitVerifyInfoByUnitIdList(@RequestBody List<Integer> unitMasterIdList);

    @RequestMapping(value = "/api/unit/getUnitLiftStatByUnitIdList", method = RequestMethod.POST)
    public RpcResult<List<UnitMaintLiftStatDTO>> getUnitLiftStatByUnitIdList(@RequestBody UnitLiftStatQuery query);


    @RequestMapping(value = "/api/unit/switchUnitAdv", method = RequestMethod.GET)
    public RpcResult switchUnitAdv(@RequestParam("unitMasterId") Integer unitMasterId,
                                   @RequestParam("switchType") Integer switchType);


    @RequestMapping(value = "/api/unit/unitAdvDetail", method = RequestMethod.GET)
    public RpcResult<Integer> unitAdvDetail(@RequestParam("unitMasterId") Integer unitMasterId);


    /**
     * 实名认证
     * @param cardNo
     * @param realName
     * @return
     */
    @RequestMapping(value = "/apiUser/idCardAuth/v2", method = RequestMethod.GET)
    RpcResult<IdAuthDTO> idCardAuth(@RequestParam("cardNo") String cardNo,
                                    @RequestParam("realName") String realName);

    /**
     * 检验单位名和统一信用代码
     * @param unitName
     * @param creditCode
     * @return
     */
    @RequestMapping(value = "/api/unit/checkCreditCode", method = RequestMethod.GET)
    RpcResult<Boolean> checkUnitNameAndCreditCode(@RequestParam("unitName") String unitName,
                                                      @RequestParam("creditCode") String creditCode);
}
