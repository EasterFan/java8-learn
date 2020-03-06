package stream;

import com.alibaba.fastjson.JSON;
import com.java8.lambda.cart.CartService;
import com.java8.lambda.cart.Product;
import com.java8.lambda.cart.ProductCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 演示流的各种操作
 */
public class StreamOperator {
    List<Product> cartList;

    @Before
    public void init() {
        cartList = new CartService().cartList;
    }

    @Test
    public void filterTest() {
        cartList.stream()
                // 过滤：留下符合条件的，去掉不符合的 - 判断 Predicate
                .filter(product -> ProductCategoryEnum.BOOKS.equals(product.getProductCategory()))
                .forEach(product -> System.out.println(JSON.toJSONString(product, true)));
    }

    @Test
    public void mapTest() {
        cartList.stream()
                // 映射：将一个元素转换成另一个元素 - 转换 Function
                .map(product -> product.getProductName())
                .forEach(product -> System.out.println(JSON.toJSONString(product, true)));
    }

    @Test
    public void flatMapTest() {
        cartList.stream()
                // 扁平化：将一个元素转换成另一个元素,并拍平输出 - 转换 Function
                .flatMap(product -> Arrays.stream(product.getProductName().split("")))
                .forEach(product -> System.out.println(JSON.toJSONString(product, true)));
    }

    @Test
    public void peekTest() {
        cartList.stream()
                // 遍历：中间操作 - 消费 Consumer
                .peek(product -> System.out.println(product.getProductName()))
                .forEach(product -> System.out.println(JSON.toJSONString(product, true)));
    }

    @Test
    public void sortTest() {
        cartList.stream()
                // 排序：中间操作 - 比较 Comparator
                .sorted(Comparator.comparing(Product::getTotalPrice))
                .forEach(product -> System.out.println(JSON.toJSONString(product, true)));
    }

    @Test
    public void distinctTest() {
        cartList.stream()
                .map(Product::getProductCategory)
                // 去重：对产品的种类进行去重
                .distinct()
                .forEach(product -> System.out.println(JSON.toJSONString(product, true)));
    }

    @Test
    public void skipTest() {
        cartList.stream()
                .map(Product::getProductCategory)
                // 过滤：过滤前3条数据
                .skip(3)
                .forEach(product -> System.out.println(JSON.toJSONString(product, true)));
    }

    @Test
    public void limitTest() {
        cartList.stream()
                .map(Product::getProductCategory)
                // 过滤：只取集合中的前 3 条数据
                .limit(3)
                .forEach(product -> System.out.println(JSON.toJSONString(product, true)));
    }

    @Test
    public void allMatchTest() {
        boolean match = cartList.stream()
                // 检查流中元素是否都满足某个条件，都满足 -> true, 有一个不满足 -> false
                .allMatch(product -> product.getTotalPrice() > 100);
        System.out.println(match);
    }

    @Test
    public void anyMatchTest() {
        boolean match = cartList.stream()
                // 检查流中元素是否有一个满足某个条件，任意一个满足 -> true, 都不满足 -> false
                .anyMatch(product -> product.getTotalPrice() > 100);
        System.out.println(match);
    }

    @Test
    public void nonMatchTest() {
        boolean match = cartList.stream()
                // 检查流中元素所有元素都不满足，所有元素都不满足 -> true, 有一个满足 -> false
                .noneMatch(product -> product.getTotalPrice() > 100);
        System.out.println(match);
    }

    @Test
    public void findFirstTest() {
        Optional<Product> optional = cartList.stream()
                //  返回第一个
                .findFirst();
        System.out.println(JSON.toJSONString(optional.get(), true));
    }

    @Test
    public void findAnyTest() {
        Optional<Product> optional = cartList.stream()
                //  只要有就返回
                .findAny();
        System.out.println(JSON.toJSONString(optional.get(), true));
    }

    @Test
    public void maxTest() {
        OptionalDouble optional = cartList.stream()
                .mapToDouble(Product::getProductPrice)
                //  最大值
                .max();
        System.out.println(JSON.toJSONString(optional.getAsDouble(), true));
    }

    @Test
    public void countTest() {
        long count = cartList.stream()
                .count();
        System.out.println(count);
    }

    @Test
    public void reduceTest() {
        Optional name = cartList.stream()
                .map(Product::getProductName)
                .reduce((n1, n2) -> n1 + n2);
        name.ifPresent(System.out::println);
    }

    @Test
    public void collectTest() {
        Map<Double, List<Product>> productsByPrice = cartList
                .stream()
                // 根据商品单价分组
                .collect(Collectors.groupingBy(p -> p.getProductPrice()));

        productsByPrice
                .forEach((price, p) -> System.out.format("price %s: %s\n", price, p.get(0).getProductName()));

        // 获得统计信息
        DoubleSummaryStatistics phrase = cartList
                .stream()
                .collect(Collectors.summarizingDouble((Product p) -> p.getProductPrice()));

        System.out.println(phrase);

        // 拼接字符串
        String phrase2 = cartList
                .stream()
                .map(Product::getProductName)
                .collect(Collectors.joining(" and ","In this cart, "," will come to you soon."));

        System.out.println(phrase2);

        // Stream 转 map
        Map<String, Double> map = cartList
                .stream()
                .collect(Collectors.toMap(
                        Product::getProductName,
                        Product::getProductPrice));

        System.out.println(map);
    }
}
