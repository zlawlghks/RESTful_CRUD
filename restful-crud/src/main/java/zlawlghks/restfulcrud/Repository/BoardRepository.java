package zlawlghks.restfullcrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zlawlghks.restfullcrud.Post.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
