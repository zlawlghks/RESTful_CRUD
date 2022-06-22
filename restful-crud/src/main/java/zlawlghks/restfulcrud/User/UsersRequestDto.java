package zlawlghks.restfullcrud.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestDto {
    private Integer userId;
    private String userName;
    private String userPassword;

    public Users toUserEntity() {
        return Users.builder()
                .userName(userName)
                .userPassword(userPassword)
                .build();
    }
}
