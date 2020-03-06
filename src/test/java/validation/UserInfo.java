package validation;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * 待验证对象实体类
 */
@Data
public class UserInfo {
    @NotNull(message = "user id can not be null")
    private String userId;
    private String username;
    private Stream password;
    private String email;
    private String phone;
    private Date birthday;
    private List<UserInfo> friendsList;
}
