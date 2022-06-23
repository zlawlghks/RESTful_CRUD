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

    // 생성
    @PostMapping("/posts")
    public ResponseEntity<BoardResponseDto> create(@RequestBody BoardRequestDto boardRequestDto) {
        return new ResponseEntity<>(boardService.createBoard(boardRequestDto), HttpStatus.CREATED);
    }

    // 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<BoardResponseDto> update(@PathVariable Integer id, @RequestBody BoardRequestDto boardRequestDto) {
        return new ResponseEntity<>(boardService.updateBoard(id, boardRequestDto), HttpStatus.OK);
    }

    // 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<BoardResponseDto> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(boardService.deleteBoard(id), HttpStatus.OK);
    }

    // 전체 조회
    @GetMapping("/posts")
    public ResponseEntity<List<BoardResponseDto>> getAll() {
        return new ResponseEntity<>(boardService.getAllBoard(), HttpStatus.OK);
    }

    // 상세 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<BoardResponseDto> getOne(@PathVariable Integer id) {
        return new ResponseEntity<>(boardService.getOneBoard(id), HttpStatus.OK);
    }
}
