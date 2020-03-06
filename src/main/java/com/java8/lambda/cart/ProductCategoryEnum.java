package com.java8.lambda.cart;

import lombok.AllArgsConstructor;

/**
 * 商品类型枚举
 */
@AllArgsConstructor
public enum ProductCategoryEnum {
    CLOTHING(10,"服装类"),
    ELECTRONICS(20,"数码类"),
    SPORTS(30,"运动类"),
    BOOKS(40,"图书类");

    private Integer code;
    private String name;
}
