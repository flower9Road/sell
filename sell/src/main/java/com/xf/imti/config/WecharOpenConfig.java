package com.xf.imti.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by 874879659 on 2018/5/15.
 */
@Component
public class WecharOpenConfig {
    @Autowired
    WechatAccountConfig accountConfig;

    @Bean
    public WxMpService wxOpenService() {
        WxMpService service = new WxMpServiceImpl();
        service.setWxMpConfigStorage(wxMpConfigStorage());
        return service;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage =new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(accountConfig.getOpenAppId());
        wxMpInMemoryConfigStorage.setSecret(accountConfig.getOpenAppSecret());
        return wxMpInMemoryConfigStorage;
    }
}
