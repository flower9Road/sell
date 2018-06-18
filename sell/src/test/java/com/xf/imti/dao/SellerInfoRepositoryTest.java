package com.xf.imti.dao;

import com.xf.imti.entity.SellerInfo;
import com.xf.imti.utils.KeyUtil;
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
public class SellerInfoRepositoryTest {
    @Autowired
    SellerInfoRepository repository;
    @Test
    public void save() throws Exception {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        SellerInfo result= repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOpenid() throws Exception{
        SellerInfo result = repository.findByOpenid("abc");
        Assert.assertEquals("abc",result.getOpenid());
    }
}