package com.roy.spring_boot_mall.dao;

import com.roy.spring_boot_mall.dto.ProductRequest;
import com.roy.spring_boot_mall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
    Integer createProduct (ProductRequest productRequest);

    void updateProduct(Integer productId , ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
