package com.encodesolution.product.dao;

import com.encodesolution.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * TODO use real database
 */
@Repository
public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();

    public Product save(Product product) {
        productList.add(product);
        return product;
    }

    public Product getProduct(final long barcode) {
        Optional<Product> toReturnProduct = productList.stream()
                .filter(product -> product.getBarcode() == barcode).findFirst();
        return toReturnProduct.orElse(null);
    }
}