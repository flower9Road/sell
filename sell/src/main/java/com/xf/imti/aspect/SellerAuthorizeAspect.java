package com.xf.imti.aspect;

import com.xf.imti.constant.CookieConstant;
import com.xf.imti.constant.RedisConstant;
import com.xf.imti.exception.SellerAuthorizeException;
import com.xf.imti.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 874879659 on 2018/5/16.
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("execution(public  * com.xf.imti.controller.seller*.*(..))"+
            "&& !execution(public * com.xf.imti.controller.SellerUserController.*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        Cookie cookie= CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie==null){
            log.warn("【登陆校验】cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        String tokenValue= stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)){
            log.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }
    }
}
