package com.xf.imti.dto;

import lombok.Data;

/**
 * Created by 874879659 on 2018/4/23.
 */
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
