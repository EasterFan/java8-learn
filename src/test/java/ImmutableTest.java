import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.UnmodifiableIterator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author 樊东方
 * @Date 2020/9/17 10:52 上午
 * @Description
 */
public class ImmutableTest {

    public static void main(String[] args) {
        List list = Stream.of("1", "2", "3").collect(Collectors.toList());

        // jdk 提供的不可变集合，相对较为繁琐
        List newList = Collections.unmodifiableList(list);
        test(newList);

        // 1. 通过已存在的集合创建
        ImmutableSet immutableSet = ImmutableSet.copyOf(list);

        // 2. 通过初始值，直接创建不可变集合
        ImmutableSet<Integer> immutableSet1 = ImmutableSet.of(1, 2, 3);

        // 3. 通过 Builder 创建
        ImmutableSet<Integer> immutableSet2 = ImmutableSet.<Integer>builder()
                .add(4)
                .addAll(immutableSet1)
                .add(5)
                .build();

        // 4. 创建同时进行排序
        ImmutableSortedSet<String> sortedSet = ImmutableSortedSet.of("a","b","c","d");
        UnmodifiableIterator<String> iterator = sortedSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()); // a,b,c,d
        }
    }


    // 场景： 可变集合在某个方法里被调用时删除了元素，引用传递存在这样的风险
    private static void test(List list) {
        list.remove(0);
    }
}
