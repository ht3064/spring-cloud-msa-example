package com.example.catalogservice.service;

import com.example.catalogservice.jpa.CatalogEntity;
import com.example.catalogservice.vo.ResponseStock;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
    ResponseStock getStockByProductId(String productId);
}
