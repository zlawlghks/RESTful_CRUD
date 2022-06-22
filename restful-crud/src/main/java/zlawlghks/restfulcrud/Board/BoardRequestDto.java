package zlawlghks.restfullcrud.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequestDto {
    private Integer boardId;
    private String title;
    private String content;

    public Board toBoardEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
