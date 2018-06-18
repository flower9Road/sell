package com.xf.imti.entity.mapper;

import com.xf.imti.entity.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by 874879659 on 2018/5/17.
 */

public interface ProductCategoryMapper {
    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory category);

    @Select("select * from product_category where category_type=#{categoryType}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType"),
    })
    ProductCategory FindByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name=#{categoryName}")
    @Results({
            @Result(column = "category_id",property = "categoryId"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_type",property = "categoryType"),
    })
    List<ProductCategory> FindByCategoryName(String categoryName);


    @Update("update product_category set category_name=#{categoryName} where category_type=#{categoryType}")
    int updateCategoryType(@Param("categoryName") String categoryName,
                           @Param("categoryType") Integer categoryType);

    @Update("update product_category set category_name=#{categoryName} where category_type=#{categoryType}")
    int updateProductCategory(ProductCategory category);
}
