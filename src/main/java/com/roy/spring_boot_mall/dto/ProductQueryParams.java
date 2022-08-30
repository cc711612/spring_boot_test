package com.roy.spring_boot_mall.dto;

import com.roy.spring_boot_mall.constant.ProductCategory;
import lombok.Data;


@Data
public class ProductQueryParams {

    private ProductCategory productCategory;
    private String search;
    private String orderBy;
    private String sort;

    private Integer limit;
    private Integer offset;
}
