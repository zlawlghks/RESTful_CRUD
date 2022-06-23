package zlawlghks.restfullcrud.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseDto {
    private Integer userId;
    private String userName;
    private String userPassword;

    public UsersResponseDto(Users user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
    }
}
