package com.roy.spring_boot_mall.rowmapper;

import com.roy.spring_boot_mall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setCategory(resultSet.getString("category"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getInt("price"));
        product.setImageUrl(resultSet.getString("image_url"));
        product.setStock(resultSet.getInt("stock"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
        return product;
    }
}