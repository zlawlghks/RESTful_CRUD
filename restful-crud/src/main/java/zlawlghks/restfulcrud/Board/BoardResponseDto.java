package zlawlghks.restfullcrud.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {
    private Integer boardId;
    private String title;
    private String content;

    public BoardResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
