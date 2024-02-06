package com.breeze.springapi.controller;

import com.breeze.springapi.common.Constants;
import com.breeze.springapi.common.exception.SpringAPIException;
import com.breeze.springapi.data.dto.ProductDto;
import com.breeze.springapi.service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }




    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform [{}] of Spring API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info("[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(),
                productDto.getProductName(),
                productDto.getProductPrice(),
                productDto.getProductStock(),
                (System.currentTimeMillis() - startTime)
        );

        return productDto;
    }

    // http://localhost:8080/api/v1/product-api/product
    @PostMapping(value = "/product")
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
        LOGGER.info("[createProduct] perform {} of Spring API.", "createProduct");

        // Validation Code Example
        /*
        if (productDto.getProductId().equals("") || productDto.getProductId().isEmpty()) {
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
        }
        */

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info("[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(),
                response.getProductName(),
                response.getProductPrice(),
                response.getProductStock()
        );

        //return productService.saveProduct(productId, productName, productPrice, productStock);
        return response;
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }

    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws SpringAPIException {
        throw new SpringAPIException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "prohibit access(접근금지).");
    }



}
