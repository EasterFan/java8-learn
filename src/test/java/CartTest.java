import com.alibaba.fastjson.JSON;
import com.java8.lambda.cart.CartService;
import com.java8.lambda.cart.Product;
import com.java8.lambda.cart.ProductPredicate;
import com.java8.lambda.cart.ProductTotalPricePredicate;
import org.junit.Test;

import java.util.List;

public class CartTest {
    @Test
    public void should_return_all_electronic_product() {
        System.out.println(JSON.toJSONString(CartService.getAllElectricProduct(new CartService().getCartList()), true));
    }

    @Test
    public void should_filter_product() {
        List<Product> cartList = new CartService().getCartList();

//        List<Product> result = CartService.getSpecificProduct(cartList, new ProductTotalPricePredicate());
//
//        // 匿名类等价写法
//        List<Product> result2 = CartService.getSpecificProduct(cartList, new ProductPredicate() {
//            @Override
//            public boolean test(Product product) {
//                return product.getTotalPrice() > 200;
//            }
//        });

        // Lambda 等价写法
        List<Product> result3 = CartService.getSpecificProduct(cartList,
                (Product product) -> product.getTotalPrice() > 200);

        System.out.println(JSON.toJSONString(result3, true));
    }
}
