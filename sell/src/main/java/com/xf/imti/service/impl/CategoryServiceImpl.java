package com.xf.imti.service.impl;

import com.xf.imti.dao.ProductCategoryRepository;
import com.xf.imti.entity.ProductCategory;
import com.xf.imti.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 874879659 on 2018/4/20.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    ProductCategoryRepository repository;

    @Override
    public ProductCategory findById(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
