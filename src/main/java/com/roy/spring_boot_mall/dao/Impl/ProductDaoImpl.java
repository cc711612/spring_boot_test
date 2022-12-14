package com.roy.spring_boot_mall.dao.Impl;

import com.roy.spring_boot_mall.constant.ProductCategory;
import com.roy.spring_boot_mall.dao.ProductDao;
import com.roy.spring_boot_mall.dto.ProductQueryParams;
import com.roy.spring_boot_mall.dto.ProductRequest;
import com.roy.spring_boot_mall.model.Product;
import com.roy.spring_boot_mall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Product> getList(ProductQueryParams productQueryParams) {
        String sql = "SELECT product_id ,product_name, category, image_url, price, stock, description, created_date, last_modified_date FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();
        sql = addFilterSql(sql, map, productQueryParams);
        sql += " ORDER BY " + productQueryParams.getOrderBy() + " " + productQueryParams.getSort() +
                " limit " + productQueryParams.getLimit() + " offset " + productQueryParams.getOffset();

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

    @Override
    public Integer getProductCount(ProductQueryParams productQueryParams) {
        String sql = "SELECT count(*) FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();
        sql = addFilterSql(sql, map, productQueryParams);
        return namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
    }

    private String addFilterSql(String sql, Map<String, Object> map, ProductQueryParams productQueryParams) {
        if (productQueryParams.getProductCategory() != null) {
            sql += " AND `category` = :category";
            map.put("category", productQueryParams.getProductCategory().name());
        }
        if (productQueryParams.getSearch() != null) {
            sql += " AND `product_name` LIKE :search";
            map.put("search", "%" + productQueryParams.getSearch() + "%");
        }
        return sql;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id ,product_name, category, image_url, price, stock, description, created_date, last_modified_date FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        }
        return null;
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO `product` (`product_name`, `category`, `image_url`, `price`, `stock`, `description`, `created_date`, `last_modified_date`) VALUES (:productName, :category, :imageUrl, :price, :stock, :description, :createdDate,:lastModifiedDate)";
        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE `product` SET " +
                "`product_name`=:productName, `category`=:category, `image_url`=:imageUrl, `price`=:price, `stock`=:stock, `description`=:description, `last_modified_date`=:lastModifiedDate" +
                " WHERE product_id = :productId";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM `product` WHERE product_id = :productId ";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
