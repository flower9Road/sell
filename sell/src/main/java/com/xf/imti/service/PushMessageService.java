package com.xf.imti.service;

import com.xf.imti.dto.OrderDTO;

/**
 * Created by 874879659 on 2018/5/16.
 */
public interface PushMessageService {
    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
