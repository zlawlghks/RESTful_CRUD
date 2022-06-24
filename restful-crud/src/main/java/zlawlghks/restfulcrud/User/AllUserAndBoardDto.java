package zlawlghks.restfullcrud.User;

import lombok.Getter;
import zlawlghks.restfullcrud.Post.BoardResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AllUserAndBoardDto {
    private Integer userId;
    private String userName;
    private String userPassword;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private List<BoardResponseDto> boardResponseDto;

    public AllUserAndBoardDto (Users user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
        this.createdDate = user.getCreatedDate();
        this.modifiedDate = user.getModifiedDate();
        this.boardResponseDto = user.getBoard().stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }
}
