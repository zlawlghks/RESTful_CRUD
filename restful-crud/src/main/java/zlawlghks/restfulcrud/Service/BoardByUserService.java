package zlawlghks.restfullcrud.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zlawlghks.restfullcrud.NotFoundException;
import zlawlghks.restfullcrud.Post.Board;
import zlawlghks.restfullcrud.Post.BoardRequestDto;
import zlawlghks.restfullcrud.Post.BoardResponseDto;
import zlawlghks.restfullcrud.Repository.BoardRepository;
import zlawlghks.restfullcrud.Repository.UsersRepository;
import zlawlghks.restfullcrud.User.Users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardByUserService {
    private final BoardRepository boardRepository;
    private final UsersRepository usersRepository;

    // 유저가 생성한 게시글
    @Transactional(readOnly = false)
    public BoardResponseDto createBoardByUser(Integer userId, BoardRequestDto boardRequestDto) {
        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(String.format("User ID:{%s} Not Found!", userId));
        } else {
            Board board = boardRequestDto.toBoardEntity();
            board.setUsers(optionalUser.get());

            boardRepository.save(board);

            return new BoardResponseDto(board);
        }
    }

    // 유저가 생성한 게시글 조회
    public List<BoardResponseDto> getAllBoardByUser(Integer userId) {
        Optional<Users> optionalUser = usersRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(String.format("User ID:{%s} Not Found!", userId));
        } else {
            return optionalUser.get().getBoard().stream()
                    .map(BoardResponseDto::new)
                    .collect(Collectors.toList());
        }
    }
}
