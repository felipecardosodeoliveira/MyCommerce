package com.commerce.controllers;

import com.commerce.dto.ProductDTO;
import com.commerce.entities.Product;
import com.commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public ProductDTO save(@RequestBody Product product) {
        return productService.save(product);
    }

}
