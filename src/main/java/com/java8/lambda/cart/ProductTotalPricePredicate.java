package com.java8.lambda.cart;

/**
 * 对商品总价是否超出200作为判断标准
 */
public class ProductTotalPricePredicate implements ProductPredicate {
    @Override
    public boolean test(Product product) {
        return product.getTotalPrice() > 200;
    }
}
