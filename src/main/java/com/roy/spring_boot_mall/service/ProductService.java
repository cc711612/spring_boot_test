package com.roy.spring_boot_mall.service;

import com.roy.spring_boot_mall.constant.ProductCategory;
import com.roy.spring_boot_mall.dto.ProductQueryParams;
import com.roy.spring_boot_mall.dto.ProductRequest;
import com.roy.spring_boot_mall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getList(ProductQueryParams productQueryParams);

    Integer getProductCount(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
