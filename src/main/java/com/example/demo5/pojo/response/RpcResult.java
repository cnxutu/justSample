package com.example.demo5.pojo.response;

import lombok.Data;

/**
 * @author: xutu
 * @since: 2023/10/31 14:36
 */
@Data
public class RpcResult<T> {

    private Integer code;

    private T data;

    private String message;

}
