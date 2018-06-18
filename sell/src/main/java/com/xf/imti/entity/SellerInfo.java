package com.xf.imti.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 874879659 on 2018/5/15.
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

}
