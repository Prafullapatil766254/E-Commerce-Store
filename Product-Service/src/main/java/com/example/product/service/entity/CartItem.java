package com.example.product.service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class CartItem {

    private String productId;

    private String productName;

    private Integer quantity;

    private Long price;
}
