package com.java8.lambda.cart;

/**
 * Product 选择谓词接口（根据属性选择判断标准）
 */
public interface ProductPredicate {
    boolean test(Product product);
}
