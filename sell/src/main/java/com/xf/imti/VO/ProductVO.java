package com.xf.imti.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 874879659 on 2018/4/22.
 */
@Data
public class ProductVO implements Serializable {


    private static final long serialVersionUID = -4544162513649663742L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
