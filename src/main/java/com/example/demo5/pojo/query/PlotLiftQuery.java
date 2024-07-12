package com.example.demo5.pojo.query;

import lombok.Data;

import java.util.List;

/**
 * @author: xutu
 * @since: 2024/5/31 15:49
 */
@Data
public class PlotLiftQuery {

    private String searchSeg;

    private List<Integer> unitMasterIdList;

    private Integer index;

    private Integer size;

}
