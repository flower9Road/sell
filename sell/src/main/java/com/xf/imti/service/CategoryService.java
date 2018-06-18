package com.xf.imti.service;

import com.xf.imti.entity.ProductCategory;

import java.util.List;

/**
 * Created by 874879659 on 2018/4/20.
 */
public interface CategoryService {
    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    ProductCategory save(ProductCategory productCategory);
}
