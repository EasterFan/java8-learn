import com.java8.optional.Car;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author 樊东方
 * @Date 2020/9/4 2:14 下午
 * @Description
 */
public class OptionalTest {
    @Test
    public void test() throws Throwable {
        // 1. 创建一个 Optional
        Optional.empty();

        Optional.of("123");

        Optional optional = Optional.ofNullable(new Car());

        // 2. 判断是否存在引用缺失（不推荐直接使用，和用null直接判空没区别）
        optional.isPresent();

        // 当 Optional 存在时
        optional.ifPresent(System.out::println);

        // 当引用缺失时可使用的方法
        optional.orElse("引用缺失！");

        optional.orElseGet(() -> "自定义引用缺失");

        optional.orElseThrow(() -> {
            throw new RuntimeException("空指针！引用缺失异常");
        });
    }

    public static void stream(List list) {
        // 一般没判空的做法
        list.stream().forEach(System.out::println);
        // 对集合操作前 stream 进行判空操作
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        stream(null);
    }
}
