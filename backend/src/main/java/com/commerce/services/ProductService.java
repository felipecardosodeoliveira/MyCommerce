package com.commerce.services;

import com.commerce.dto.ProductDTO;
import com.commerce.entities.Product;
import com.commerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = result.get();
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> result = productRepository.findAll();
        return result
                .stream()
                .map(ProductDTO::new)
                .toList();
    }

    public ProductDTO save(Product product) {
        productRepository.save(product);
        return new ProductDTO(product);
    }
}
