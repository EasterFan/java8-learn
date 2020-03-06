package com.java8.lambda.file;

/**
 * 自定义函数式接口
 */

@FunctionalInterface
public interface FileConsumerInterface {
    // 文件内容字符串
    void executeFile(String fileContent);
}
