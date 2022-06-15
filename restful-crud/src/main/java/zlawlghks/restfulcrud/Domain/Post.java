package zlawlghks.restfulcrud.Domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Integer id; // 기본 값
    private String description; // 게시물 내용
    private String boardName; // 게시물 이름
    private Date joinDate; // 등록 시간

//    public Post(int id, String description, String boardName, Date joinDate) {
//        this.id = id;
//        this.boardName = boardName;
//        this.description = description;
//        this.joinDate = joinDate;
//    }
}
