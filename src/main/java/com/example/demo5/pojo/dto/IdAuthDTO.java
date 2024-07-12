package com.example.demo5.pojo.dto;

import lombok.Data;

@Data
public class IdAuthDTO {
    private Integer error_code;
    private String reason;
    private Object result;
    private String ordersign;
}
