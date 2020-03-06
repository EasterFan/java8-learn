package stream;

import com.alibaba.fastjson.JSON;
import com.java8.lambda.cart.CartService;
import com.java8.lambda.cart.Product;
import com.java8.lambda.cart.ProductCategoryEnum;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 对比：原始集合操作和Stream集合操作
 */


public class StreamOriginPK {
    /**
     * 需求：
     * 1.查看购物车中所有商品
     * 2.图书类商品都给买
     * 3.其余商品中买两件最贵的
     * 4.求两件商品的名称和总价
     */

    @Test
    public void originHandle() {
        List<Product> cartList = new CartService().cartList;

        // 1. 打印所有商品
        for (Product product : cartList) {
            System.out.println(JSON.toJSONString(product, true));
        }

        // 2.过滤掉图书类


    }

    @Test
    public void streamHandle() {
        List<Product> cartList = new CartService().cartList;
        AtomicReference<Double> money = new AtomicReference<>(0.0);

        List result = cartList.stream()
                // 打印所有商品
                .peek(product -> System.out.println(JSON.toJSONString(product, true)))
                // 过滤留下符合条件的项
                .filter(product -> !ProductCategoryEnum.BOOKS.equals(product.getProductCategory()))
                // 按照总价格排序
                .sorted(Comparator.comparing(Product::getTotalPrice).reversed())
                // 取前两个
                .limit(2)
                // 计算总价
                .peek(product -> money.set(money.get() + product.getTotalPrice()))
                // 取出名字
                .map(Product::getProductName)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result, true));
    }
}
