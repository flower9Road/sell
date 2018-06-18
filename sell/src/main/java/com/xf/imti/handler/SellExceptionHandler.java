package com.xf.imti.handler;

import com.xf.imti.VO.ResultVO;
import com.xf.imti.config.ProjectUrlConfig;
import com.xf.imti.exception.SellException;
import com.xf.imti.exception.SellerAuthorizeException;
import com.xf.imti.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 874879659 on 2018/5/16.
 */
@ControllerAdvice
public class SellExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登陆异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }


    @ExceptionHandler(value =SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
