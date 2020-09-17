package com.java8.optional;

import lombok.Data;

import java.util.Optional;

/**
 * @Author 樊东方
 * @Date 2020/9/4 2:08 下午
 * @Description
 */
@Data
public class Person {
    /**
     * 人可能有车，也可能没车
     */
    private Optional<Car> car;
}
