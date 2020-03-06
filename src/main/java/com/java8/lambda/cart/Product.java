package com.java8.lambda.cart;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 下单商品信息
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Product {
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer totalNum;
    private Double totalPrice;
    private Enum productCategory;
}
