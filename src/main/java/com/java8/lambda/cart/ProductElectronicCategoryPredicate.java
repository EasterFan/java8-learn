package com.java8.lambda.cart;

/**
 * 对数码类商品的过滤条件判断
 */
public class ProductElectronicCategoryPredicate implements ProductPredicate{
    @Override
    public boolean test(Product product) {
        return ProductCategoryEnum.ELECTRONICS.equals(product.getProductCategory());
    }
}
