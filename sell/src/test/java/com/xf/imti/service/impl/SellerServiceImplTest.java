package com.xf.imti.service.impl;

import com.xf.imti.entity.SellerInfo;
import com.xf.imti.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 874879659 on 2018/5/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {
    private static final String openid = "abc";
    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo result = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid, result.getOpenid());
    }
}