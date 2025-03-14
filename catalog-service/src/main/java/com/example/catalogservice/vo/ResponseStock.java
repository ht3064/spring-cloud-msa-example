package com.example.catalogservice.vo;

public record ResponseStock(String productId, int stock) {
    public static ResponseStock of(String productId, int stock) {
        return new ResponseStock(productId, stock);
    }
}
