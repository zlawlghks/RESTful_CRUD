package zlawlghks.restfullcrud.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zlawlghks.restfullcrud.NotFoundException;
import zlawlghks.restfullcrud.Post.Board;
import zlawlghks.restfullcrud.Post.BoardRequestDto;
import zlawlghks.restfullcrud.Post.BoardResponseDto;
import zlawlghks.restfullcrud.Repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시글 생성, 수정, 삭제, 조회(전체, 상세)

    // 게시글 생성
    @Transactional(readOnly = false)
    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = boardRequestDto.toBoardEntity();
        boardRepository.save(board);

        return new BoardResponseDto(board);
    }

    // 게시글 수정
    @Transactional(readOnly = false)
    public BoardResponseDto updateBoard(Integer boardId, BoardRequestDto boardRequestDto) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if (optionalBoard.isEmpty()) {
            throw new NotFoundException(String.format("Board ID:{%s} Not Found!", boardId));
        } else {
            optionalBoard.get().update(boardRequestDto.getTitle(), boardRequestDto.getContent());

            return new BoardResponseDto(optionalBoard.get());
        }
    }

    // 게시글 삭제
    @Transactional(readOnly = false)
    public BoardResponseDto deleteBoard(Integer boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if (optionalBoard.isEmpty()) {
            throw new NotFoundException(String.format("Board ID:{%s} Not Found!", boardId));
        } else {
            BoardResponseDto responseDto = new BoardResponseDto(optionalBoard.get());
            boardRepository.deleteById(boardId);
            return responseDto;
        }
    }

    // 게시글 전체 조회
    public List<BoardResponseDto> getAllBoard() {
        return boardRepository.findAll().stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    // 게시글 상세 조회
    public BoardResponseDto getOneBoard(Integer boardId) {
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if (optionalBoard.isEmpty()) {
            throw new NotFoundException(String.format("Board ID:{%s} Not Found!", boardId));
        } else {
            return new BoardResponseDto(optionalBoard.get());
        }
    }
}
