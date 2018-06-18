package com.xf.imti.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 874879659 on 2018/4/22.
 */
@Data
public class ResultVO<T> implements Serializable{

    private static final long serialVersionUID = 6016965700812993179L;
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
