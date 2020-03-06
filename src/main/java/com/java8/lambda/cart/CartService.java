package com.java8.lambda.cart;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Getter
public class CartService {
    // 加一点假数据
    public List<Product> cartList = new ArrayList<Product>() {
        {
            add(Product.builder().productId(110)
                    .productName("helicopter")
                    .productPrice(100.00)
                    .totalNum(1)
                    .productCategory(ProductCategoryEnum.ELECTRONICS)
                    .totalPrice(100.00).build());

            add(Product.builder().productId(120)
                    .productName("iphone")
                    .productPrice(200.00)
                    .totalNum(2)
                    .productCategory(ProductCategoryEnum.ELECTRONICS)
                    .totalPrice(400.00).build());

            add(Product.builder().productId(130)
                    .productName("t-shirt")
                    .productPrice(10.00)
                    .totalNum(2)
                    .totalPrice(20.00)
                    .productCategory(ProductCategoryEnum.CLOTHING)
                    .build());

            add(Product.builder().productId(140)
                    .productName("javaBook")
                    .productPrice(100.00)
                    .totalNum(1)
                    .productCategory(ProductCategoryEnum.BOOKS)
                    .totalPrice(100.00).build());

            add(Product.builder().productId(150)
                    .productName("soccer")
                    .productPrice(10.00)
                    .totalNum(2)
                    .totalPrice(20.00)
                    .productCategory(ProductCategoryEnum.SPORTS)
                    .build());
        }
    };

    // 需求1：找出购物车中所有电子产品
    public static List<Product> getAllElectricProduct(List<Product> cartList) {
        List<Product> result = new ArrayList<>();

        for (Product product : cartList) {
            if (product.getProductCategory().equals("数码")) {
                result.add(product);
            }
        }
        return result;
    }

    // 需求2：购物车中某种类型的商品有哪些
    public static List<Product> getSpecificProductByCategory(ProductCategoryEnum productCategoryEnum, List<Product> cartList) {
        List<Product> result = new ArrayList<>();

        for (Product product : cartList) {
            if (product.getProductCategory().equals(productCategoryEnum.ELECTRONICS)) {
                result.add(product);
            }
        }
        return result;
    }

    // 需求3：根据不同的product判断标准，对cartList列表进行过滤
    public static List<Product> getSpecificProduct(List<Product> cartList, Predicate<Product> productPredicate) {
        List<Product> result = new ArrayList<>();

        for (Product product : cartList) {
            // 判断是否符合过滤标准
            if (productPredicate.test(product)) {
                result.add(product);
            }
        }
        return result;
    }


}
