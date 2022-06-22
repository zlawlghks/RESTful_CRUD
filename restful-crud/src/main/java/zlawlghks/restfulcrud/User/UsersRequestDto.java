package zlawlghks.restfullcrud.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestDto {
    private Integer userId;
    private String userName;
    private String userPassword;
    private Date userCreateDate;

    public Users toUserEntity() {
        return Users.builder()
                .userName(userName)
                .userPassword(userPassword)
                .userCreateDate(userCreateDate)
                .build();
    }
}
