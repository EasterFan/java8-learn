package com.java8.lambda.file;

import com.java8.lambda.cart.Product;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * 文件服务类
 */
public class FileService {
    public void executeFile(String url, FileConsumerInterface fileConsumerInterface) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(url))
        );

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }

        fileConsumerInterface.executeFile(stringBuilder.toString());
    }
}