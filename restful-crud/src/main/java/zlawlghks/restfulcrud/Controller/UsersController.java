package zlawlghks.restfullcrud.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zlawlghks.restfullcrud.Service.UsersService;
import zlawlghks.restfullcrud.User.UsersRequestDto;
import zlawlghks.restfullcrud.User.UsersResponseDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsersController {

    private final UsersService usersService;

    // 유저 생성
    @PostMapping("/users")
    public ResponseEntity<UsersResponseDto> create(@RequestBody UsersRequestDto usersRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usersService.createUser(usersRequestDto));
    }

    // 유저 수정
    @PutMapping("/users/{id}")
    public ResponseEntity<UsersResponseDto> update(@PathVariable Integer id, @RequestBody UsersRequestDto usersRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(usersService.updateUser(id, usersRequestDto));
    }

    // 유저 삭제
    @DeleteMapping("/users/{id}")
    public ResponseEntity<UsersResponseDto> delete(@PathVariable Integer id) {
        usersService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 유저 전체 조회
    @GetMapping("/users")
    public ResponseEntity<List<UsersResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(usersService.getAllUser());
    }

    // 유저 상세 조회
    @GetMapping("users/{id}")
    public ResponseEntity<UsersResponseDto> getOne(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(usersService.getOneUser(id));
    }
}
