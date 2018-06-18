package com.xf.imti.service.impl;

import com.xf.imti.entity.ProductCategory;
import com.xf.imti.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 874879659 on 2018/4/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    CategoryService service;
    @Test
    public void findById() throws Exception {
        ProductCategory productCategory =service.findById(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList =service.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList =service.findByCategoryTypeIn(Arrays.asList(1,2));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory =new ProductCategory();
        productCategory.setCategoryName("妈妈");
        productCategory.setCategoryType(3);
        ProductCategory result = service.save(productCategory);
        Assert.assertNotNull(result);
    }

}