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
        return new ResponseEntity<>(usersService.createUser(usersRequestDto), HttpStatus.CREATED);
    }

    // 유저 수정
    @PutMapping("/users/{id}")
    public ResponseEntity<UsersResponseDto> update(@PathVariable Integer id, @RequestBody UsersRequestDto usersRequestDto) {
        return new ResponseEntity<>(usersService.updateUser(id, usersRequestDto), HttpStatus.OK);
    }

    // 유저 삭제
    @DeleteMapping("/users/{id}")
    public ResponseEntity<UsersResponseDto> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(usersService.deleteUser(id), HttpStatus.OK);
    }

    // 유저 전체 조회
    @GetMapping("/users")
    public ResponseEntity<List> getAll() {
        return new ResponseEntity<>(usersService.getAllUser(), HttpStatus.OK);
    }

    // 유저 상세 조회
    @GetMapping("users/{id}")
    public ResponseEntity<UsersResponseDto> getOne(@PathVariable Integer id) {
        return new ResponseEntity<>(usersService.getOneUser(id), HttpStatus.OK);
    }
}
