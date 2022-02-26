package com.encodesolution.product.api;

import com.encodesolution.product.model.Product;
import com.google.gson.Gson;

import java.util.UUID;

public class TestUtils {

    public static String productServiceBaseURL = "/erp/v1/products";

    public static Product getDummyProduct() {
        return new Product(UUID.randomUUID(), 1234567, "coca cola",
                "liquid", 12.78, 10, "It is very famous drink");
    }

    public static String getDummyProductInJson() {
        return new Gson().toJson(getDummyProduct());
    }
}