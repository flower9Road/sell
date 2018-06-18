package com.xf.imti.dao;

import com.xf.imti.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 874879659 on 2018/4/22.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
