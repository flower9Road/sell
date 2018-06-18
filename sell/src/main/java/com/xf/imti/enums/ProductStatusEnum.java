package com.xf.imti.enums;

import lombok.Getter;

/**
 * Created by 874879659 on 2018/4/22.
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0,"在架"),
    DOWN(1,"下架");
    private Integer code;
    private String message;
    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
