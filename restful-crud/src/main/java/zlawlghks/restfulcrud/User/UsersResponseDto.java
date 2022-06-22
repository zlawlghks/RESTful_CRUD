package zlawlghks.restfullcrud.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseDto {
    private Integer userId;
    private String userName;
    private String userPassword;
    private Date userCreateDate;

    public void toUserResponseDto(Users user) {
        this.userId = user.getUserid();
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
        this.userCreateDate = user.getUserCreateDate();
    }
}
