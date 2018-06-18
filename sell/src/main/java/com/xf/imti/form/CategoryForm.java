package com.xf.imti.form;

import lombok.Data;

/**
 * Created by 874879659 on 2018/5/9.
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
