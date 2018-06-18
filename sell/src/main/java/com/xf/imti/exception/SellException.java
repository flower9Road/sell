package com.xf.imti.exception;

import com.xf.imti.enums.ResultEnum;
import lombok.Getter;

/**
 * Created by 874879659 on 2018/4/27.
 */
@Getter
public class SellException extends RuntimeException{


    private String  message;
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
