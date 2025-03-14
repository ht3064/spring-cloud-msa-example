package com.example.userservice.client;

import com.example.userservice.error.CatalogFeignErrorDecoder;
import com.example.userservice.vo.ResponseStock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="catalog-service", configuration = CatalogFeignErrorDecoder.class)
public interface CatalogServiceClient {

    @GetMapping("/catalog-service/catalogs/{productId}/stock")
    ResponseStock getStockByProductId(@PathVariable String productId);
}