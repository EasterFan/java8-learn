package com.java8.optional;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * @Author 樊东方
 * @Date 2020/9/4 2:13 下午
 * @Description
 */
public class OptionalService {
    Optional<Car> optCar = Optional.empty();
    Optional<Car> optCar2 = Optional.of(new Car());
    Optional<Car> optCar3 = Optional.ofNullable(new Car());

    // 使用 map 从 Optional 对象中提取值
    private void getName() {
        Optional<Insurance> insurance = Optional.ofNullable(null);
        Optional<String> name = insurance.map(Insurance::getName);
        System.out.println(name);
    }

    private void getNameWithFlatMap() {
        // 使用 flatMap 连接 Optional 对象
        Optional<Person> optionalPerson = Optional.ofNullable(null);
        // Optinal 循环嵌套问题

        /*
        Optional<String> name = optionalPerson.map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName);
        */

        String optName = optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("UnKnown");
    }


}
