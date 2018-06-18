package com.xf.imti.controller;

import com.xf.imti.VO.ProductInfoVO;
import com.xf.imti.VO.ProductVO;
import com.xf.imti.VO.ResultVO;
import com.xf.imti.entity.ProductCategory;
import com.xf.imti.entity.ProductInfo;
import com.xf.imti.service.CategoryService;
import com.xf.imti.service.ProductService;
import com.xf.imti.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 874879659 on 2018/4/22.
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    @Cacheable(cacheNames = "product" ,key = "123")
    public ResultVO list(){
        /*ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        ProductVO productVO = new ProductVO();
        resultVO.setData(productVO);*/


        //1、查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2、查询类目（一次性查询）
        //精简方法（Java 8 lambda）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList= categoryService.findByCategoryTypeIn(categoryTypeList);
        //3、数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo :productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
