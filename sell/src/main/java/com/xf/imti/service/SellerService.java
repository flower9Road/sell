package com.xf.imti.service;

import com.xf.imti.entity.SellerInfo;

/**
 * Created by 874879659 on 2018/5/15.
 */
public interface SellerService {
    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
