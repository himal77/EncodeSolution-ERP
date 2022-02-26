package com.encodesolution.product.api;

import com.encodesolution.product.model.Product;
import com.encodesolution.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/erp/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

     @GetMapping
     public ResponseEntity<Object> getProducts() {
         List<Product> productList = productService.getProducts();
         if(productList.isEmpty()) {
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
         return new ResponseEntity<>(productList, HttpStatus.OK);
     }

    @GetMapping("/{barcode}")
    public ResponseEntity<Object> getProduct(@PathVariable long barcode) {
        Product product = productService.getProduct(barcode);
        if(ObjectUtils.isEmpty(product)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        if(ObjectUtils.isEmpty(savedProduct)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }
}