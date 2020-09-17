package com.java8.optional;

import lombok.Data;

import java.util.Optional;

/**
 * @Author 樊东方
 * @Date 2020/9/4 2:09 下午
 * @Description
 */
@Data
public class Car {
    /**
     * 车可能上了保险，也可能没上保险
     */
    private Optional<Insurance> insurance;
}
