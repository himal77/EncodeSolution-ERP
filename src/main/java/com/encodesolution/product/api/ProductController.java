package com.encodesolution.product.api;

import com.encodesolution.product.model.Product;
import com.encodesolution.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/erp/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @GetMapping("/{barcode}")
    public ResponseEntity<Object> getProduct(@PathVariable long barcode) {
        return new ResponseEntity<>(productService.getProduct(barcode), HttpStatus.OK);
    }
}