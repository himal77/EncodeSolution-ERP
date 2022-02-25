package com.encodesolution.product.service;

import com.encodesolution.product.dao.ProductRepository;
import com.encodesolution.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        product.setProductId(UUID.randomUUID());
        productRepository.save(product);
    }

    public Product getProduct(long barcode) {
        return productRepository.getProduct(barcode);
    }
}