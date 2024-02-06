package com.breeze.springapi.data.handler;

import com.breeze.springapi.data.entity.ProductEntity;

public interface ProductDataHandler {
    ProductEntity saveProductEntity(String productId, String productName, int productIdPrice, int productIdStock);
    ProductEntity getProductEntity(String productId);
}
