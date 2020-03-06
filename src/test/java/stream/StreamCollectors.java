package stream;

import com.alibaba.fastjson.JSON;
import com.java8.lambda.cart.CartService;
import com.java8.lambda.cart.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 常见内置流收集器的三种使用
 */
public class StreamCollectors {
    private List<Product> cartList;

    @Before
    public void init() {
        cartList = new CartService().cartList;
    }

    @Test
    public void toList() {

        List<Product> result = cartList.stream()
                .filter(product -> product.getTotalPrice() > 100)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(result, true));
    }

    @Test
    public void group() {
        // Map<分类条件，结果集合>
        Map<Object, List<Product>> result = cartList.stream()
                .collect(Collectors.groupingBy(Product::getProductCategory));
        System.out.println(JSON.toJSONString(result, true));
    }

    // 分区是分组的一个特例
    @Test
    public void partition() {
        Map<Boolean, List<Product>> partition = cartList.stream()
                .collect(Collectors.partitioningBy(product -> product.getTotalPrice() > 200));
        System.out.println(JSON.toJSONString(partition, true));
    }
}

