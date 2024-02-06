package com.breeze.springapi.data.dto;

import com.breeze.springapi.data.entity.ProductEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {
    @NotNull
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    @Min(500)
    @Max(300000)
    private int productPrice;

    @NotNull
    @Min(10)
    @Max(300)
    private int productStock;

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
