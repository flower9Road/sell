package com.xf.imti.entity.mapper;

import com.xf.imti.entity.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by 874879659 on 2018/5/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {



    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryName","师兄最不爱");
        map.put("categoryType",101);
        int a = mapper.insertByMap(map);
        Assert.assertEquals(1,a);
    }
    @Test
    public void insertByObject() throws Exception {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("师兄最爱");
        category.setCategoryType(102);
        int b = mapper.insertByObject(category);
        Assert.assertEquals(1,b);
    }

    @Test
    public void findByCategoryType() throws Exception {
        ProductCategory a= mapper.FindByCategoryType(102);
        Assert.assertNotNull(a);
    }

    @Test
    public void findByCategoryName() throws Exception {
        List<ProductCategory> a= mapper.FindByCategoryName("师兄最爱");
        Assert.assertNotEquals(a,a.size());
    }

    @Test
    public void updateCategoryType() throws Exception {
        int a = mapper.updateCategoryType("核弹爆炸",102);
        Assert.assertEquals(1,a);
    }
    @Test
    public void updateProductCategory() throws Exception {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("师兄最爱");
        category.setCategoryType(102);
        int a = mapper.updateProductCategory(category);
        Assert.assertEquals(1,a);
    }

}