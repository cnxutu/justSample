package com.example.demo5.pojo.dto;

import lombok.Data;

/**
 * @author: xutu
 * @since: 2024/4/24 13:29
 */
@Data
public class UnitMaintLiftStatDTO {

    /**
     * 单位id
     */
    private Integer unitMasterId;

    /**
     * 在保电梯数量
     */
    private Integer maintLiftCount;

}
