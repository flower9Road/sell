package com.xf.imti.service.impl;

import com.xf.imti.dao.SellerInfoRepository;
import com.xf.imti.entity.SellerInfo;
import com.xf.imti.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 874879659 on 2018/5/15.
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
