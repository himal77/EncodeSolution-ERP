package com.encodesolution.product.api;

import com.encodesolution.product.model.Product;
import com.encodesolution.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/erp/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void save(Product product) {
        productService.save(product);
    }

    @GetMapping("/{barcode}")
    public ResponseEntity<Object> getProduct(@PathVariable long barcode) {
        return new ResponseEntity<>(productService.getProduct(barcode), HttpStatus.OK);
    }
}
