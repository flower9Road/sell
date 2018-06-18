package com.xf.imti.service;

import com.xf.imti.dto.OrderDTO;

/**
 * Created by 874879659 on 2018/5/1.
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
