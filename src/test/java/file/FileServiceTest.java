package file;

import com.java8.lambda.file.FileService;
import org.junit.Test;

import java.io.IOException;

/**
 * 自定义函数式接口
 */
public class FileServiceTest {
    @Test
    public void fileHandle() throws IOException {
        FileService fileService = new FileService();

        fileService.executeFile("/Users/easterfan/Desktop/java8functionalProgramming" +
                "/src/test/java/file/FileServiceTest.java",
                fileContent -> System.out.println(fileContent));
    }
}
