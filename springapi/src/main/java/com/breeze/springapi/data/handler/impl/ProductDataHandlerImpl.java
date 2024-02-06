package com.breeze.springapi.data.handler.impl;

import com.breeze.springapi.data.dao.ProductDAO;
import com.breeze.springapi.data.entity.ProductEntity;
import com.breeze.springapi.data.handler.ProductDataHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {
    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productIdPrice, int productIdStock) {
        ProductEntity productEntity = new ProductEntity(productId, productName, productIdPrice, productIdStock);
        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDAO.getProduct(productId);
    }
}
