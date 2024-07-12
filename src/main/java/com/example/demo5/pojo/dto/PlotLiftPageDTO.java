package com.example.demo5.pojo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: xutu
 * @since: 2024/5/31 15:25
 */
@Data
public class PlotLiftPageDTO {

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

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 区编码
     */
    private String townCode;

    /**
     * 街道编码
     */
    private String streetCode;


	private List<LiftInfoDTO> liftInfoDTOList;

}
