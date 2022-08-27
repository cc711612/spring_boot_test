package com.roy.spring_boot_mall.dao;

import com.roy.spring_boot_mall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
