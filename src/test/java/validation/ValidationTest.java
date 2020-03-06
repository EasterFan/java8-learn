package validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 验证测试类
 */
public class ValidationTest {
    private Validator validator;
    private UserInfo userInfo;
    // 验证结果集合
    private Set<ConstraintViolation<UserInfo>> set;


    @Before
    public void init() {
        // 初始化验证器
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        userInfo = new UserInfo();
    }


    @After
    public void print() {
        set.forEach(item-> System.out.println(item.getMessage()));

    }

    @Test
    public void nullValidation() {
        set = validator.validate(userInfo);
    }


}
