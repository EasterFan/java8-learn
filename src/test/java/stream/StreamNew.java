package stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 演示流的四种构建形式
 */
public class StreamNew {

    /**
     * 1.由数值直接构建流
     */
    @Test
    public void streamFromValue() {
        Stream stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
    }

    /**
     * 2. 通过数组构建流
     */
    @Test
    public void streamFromArray() {
        int[] numbers = {1, 2, 3, 4, 5};

        // 根据传入的数组的类型，返回不同的包装类
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

    /**
     * 3. 通过文件构建流
     *
     * @throws IOException
     */
    @Test
    public void streamFromFile() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("/Users/easterfan/Desktop/java8functionalProgramming/src/test/java/stream/StreamNew.java"));
        stream.forEach(System.out::println);
    }


    /**
     * 4. 通过函数生成流（无限流）
     * 迭代是在原来的流上迭代生成
     * generate 生成的流不会基于上一个流，而是随机生成的流
     */
    @Test
    public void streamFromFunction() {
        Stream stream1 = Stream.iterate(0, n -> n + 2);
        Stream stream2 = Stream.generate(Math::random);
        stream1.limit(100)
                .forEach(System.out::println);
    }

}
