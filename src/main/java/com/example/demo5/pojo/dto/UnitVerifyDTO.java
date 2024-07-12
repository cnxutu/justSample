package com.example.demo5.pojo.dto;

import lombok.Data;

/**
 * @author: xutu
 * @since: 2024/4/24 11:04
 */
@Data
public class UnitVerifyDTO {

    private Integer unitMasterId;

    /**
     * 审核状态：0-待审核 1-通过 2-拒绝
     */
    private Integer isVerify;

    private String creditCode;
}
