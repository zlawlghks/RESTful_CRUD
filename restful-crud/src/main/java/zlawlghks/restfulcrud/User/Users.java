package zlawlghks.restfullcrud.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue
    private Integer userid;
    private String userName;
    private String userPassword;
    private Date userCreateDate;

    @Builder
    public Users(String userName, String userPassword, Date userCreateDate) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userCreateDate = userCreateDate;
    }


    public void update(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}