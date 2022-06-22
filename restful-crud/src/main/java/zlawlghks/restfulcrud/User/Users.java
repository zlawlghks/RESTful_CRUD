package zlawlghks.restfullcrud.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String userPassword;

    @Builder
    public Users(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }


    public void update(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @OneToMany(mappedBy = "users")
    private List<Board> board;
}
