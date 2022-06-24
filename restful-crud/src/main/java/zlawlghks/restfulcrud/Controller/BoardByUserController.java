package zlawlghks.restfullcrud.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zlawlghks.restfullcrud.Post.BoardRequestDto;
import zlawlghks.restfullcrud.Post.BoardResponseDto;
import zlawlghks.restfullcrud.Service.BoardByUserService;
import zlawlghks.restfullcrud.Service.UsersService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardByUserController {
    private final BoardByUserService boardByUserService;
    private final UsersService usersService;


    // 유저의 게시글 생성
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<BoardResponseDto> createBoardByUser(@PathVariable Integer id, @RequestBody BoardRequestDto boardRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardByUserService.createBoardByUser(id, boardRequestDto));
    }

    // 유저의 게시글 전체 조회
    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<BoardResponseDto>> getAllBoardByUser(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardByUserService.getAllBoardByUser(id));
    }
}
