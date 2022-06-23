package zlawlghks.restfullcrud.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zlawlghks.restfullcrud.NotFoundException;
import zlawlghks.restfullcrud.Repository.UsersRepository;
import zlawlghks.restfullcrud.User.Users;
import zlawlghks.restfullcrud.User.UsersRequestDto;
import zlawlghks.restfullcrud.User.UsersResponseDto;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    // 회원 생성, 수정, 삭제, 조회

    // 회원 생성
    @Transactional(readOnly = false)
    public UsersResponseDto createUser(UsersRequestDto usersRequestDto) {
        Users user = usersRequestDto.toUserEntity();
        usersRepository.save(user);

        return new UsersResponseDto(user);
    }

    // 회원 수정
    @Transactional(readOnly = false)
    public UsersResponseDto updateUser(Integer userId, UsersRequestDto usersRequestDto) {
        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(String.format("User ID:{%s} Not Found!", userId));
        } else {
            optionalUser.get().update(usersRequestDto.getUserName(), usersRequestDto.getUserPassword());
            return return new UsersResponseDto(optionalUser.get());
        }
    }

    // 회원 삭제
    @Transactional(readOnly = false)
    public String UsersResponseDto(Integer userId) {
        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(String.format("User ID:{%s} Not Found!", userId));
        } else {
            UsersResponseDto usersResponseDto = new UsersResponseDto(optionalUser.get());
            usersRepository.deleteById(userId);
            return usersResponseDto;
        }
    }

    // 회원 전체 조회
    public List<Users> getAllUser() {
        return usersRepository.findAll();
    }

    // 회원 상세 조회
    public UsersResponseDto getOneUser(Integer userId) {
        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(String.format("User ID:{%s} Not Found!", userId));
        } else {
            return new UsersResponseDto(optionalUser.get());
        }
    }

}
