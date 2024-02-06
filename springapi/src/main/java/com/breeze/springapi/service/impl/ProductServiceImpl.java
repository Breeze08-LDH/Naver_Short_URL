package com.breeze.springapi.service.impl;

import com.breeze.springapi.data.dto.ProductDto;
import com.breeze.springapi.data.entity.ProductEntity;
import com.breeze.springapi.data.handler.ProductDataHandler;
import com.breeze.springapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);
        ProductDto productDto = new ProductDto( productEntity.getProductId(),
                                                productEntity.getProductName(),
                                                productEntity.getProductPrice(),
                                                productEntity.getProductStock() );
        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);
        ProductDto productDto = new ProductDto( productEntity.getProductId(),
                                                productEntity.getProductName(),
                                                productEntity.getProductPrice(),
                                                productEntity.getProductStock() );
        return productDto;
    }

}

