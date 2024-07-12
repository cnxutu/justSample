package com.example.demo5.pojo.query;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: xutu
 * @since: 2024/4/28 14:24
 */
@Data
public class UnitLiftStatQuery {

    private List<Integer> unitMasterIdList;

    private LocalDateTime expireDateTime;

}
