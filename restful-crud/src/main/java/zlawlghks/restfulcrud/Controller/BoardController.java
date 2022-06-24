package zlawlghks.restfullcrud.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zlawlghks.restfullcrud.Post.Board;
import zlawlghks.restfullcrud.Post.BoardRequestDto;
import zlawlghks.restfullcrud.Post.BoardResponseDto;
import zlawlghks.restfullcrud.Service.BoardService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;
    // 게시글 생성, 수정, 삭제, 조회

    // 게시글 생성
    @PostMapping("/posts")
    public ResponseEntity<BoardResponseDto> create(@RequestBody BoardRequestDto boardRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.createBoard(boardRequestDto));
    }

    // 게시글 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<BoardResponseDto> update(@PathVariable Integer id, @RequestBody BoardRequestDto boardRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.updateBoard(id, boardRequestDto));
    }

    // 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204번
    }

    // 게시글 전체 조회
    @GetMapping("/posts")
    public ResponseEntity<List<BoardResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getAllBoard());
    }

    // 게시글 상세 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<BoardResponseDto> getOne(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getOneBoard(id));
    }
}
