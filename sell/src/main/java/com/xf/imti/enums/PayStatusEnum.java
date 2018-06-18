package com.xf.imti.enums;

import lombok.Getter;

/**
 * Created by 874879659 on 2018/4/23.
 */
@Getter
public enum PayStatusEnum implements CodeEnum{

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
