package com.xf.imti.dao;

import com.xf.imti.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 874879659 on 2018/5/15.
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}
