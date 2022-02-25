package com.encodesolution.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private UUID productId;
    private long barcode;
    private String name;
    private String category;
    private double price;
    private int stock;
    private String description;
}
