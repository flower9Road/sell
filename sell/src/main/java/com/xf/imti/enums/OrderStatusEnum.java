package com.xf.imti.enums;

import lombok.Getter;

/**
 * Created by 874879659 on 2018/4/23.
 */
@Getter
public enum  OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
