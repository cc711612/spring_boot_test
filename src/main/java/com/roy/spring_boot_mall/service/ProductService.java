package com.roy.spring_boot_mall.service;

import com.roy.spring_boot_mall.dto.ProductRequest;
import com.roy.spring_boot_mall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct (ProductRequest productRequest);
}
