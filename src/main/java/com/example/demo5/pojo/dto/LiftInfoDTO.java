package com.example.demo5.pojo.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: xutu
 * @since: 2024/5/31 17:05
 */
@Data
public class LiftInfoDTO {

    private Integer unitMasterId;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 小区id
     */
    private String plotId;

    /**
     * 小区名称
     */
    private String plotName;

    private String liftName;


    private String registerCode;

    /**
     * 电梯品牌
     */
    private String brandName;

    /**
     * 电梯型号
     */
    private String liftModel;

    /**
     * 生产日期
     */
    private Date manufactureDate;

    /**
     * 电梯载重，单位KG
     */
    private String liftLoad;

    /**
     * 电梯速度，单位M/s
     */
    private String liftSpeed;


}
