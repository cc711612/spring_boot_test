package com.roy.spring_boot_mall.service.Impl;

import com.roy.spring_boot_mall.constant.ProductCategory;
import com.roy.spring_boot_mall.dao.ProductDao;
import com.roy.spring_boot_mall.dto.ProductQueryParams;
import com.roy.spring_boot_mall.dto.ProductRequest;
import com.roy.spring_boot_mall.model.Product;
import com.roy.spring_boot_mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }

    @Override
    public List<Product> getList(ProductQueryParams productQueryParams) {
        return productDao.getList(productQueryParams);
    }

    @Override
    public Integer getProductCount(ProductQueryParams productQueryParams) {
        return productDao.getProductCount(productQueryParams);
    }
}
