package com.roy.spring_boot_mall.controller;

import com.roy.spring_boot_mall.dto.ProductRequest;
import com.roy.spring_boot_mall.model.Product;
import com.roy.spring_boot_mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<Product> get(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(
            @PathVariable Integer productId,
            @RequestBody @Valid ProductRequest productRequest
    ) {

        if(productService.getProductById(productId) != null){
            productService.updateProduct(productId,productRequest);

            Product product = productService.getProductById(productId);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
