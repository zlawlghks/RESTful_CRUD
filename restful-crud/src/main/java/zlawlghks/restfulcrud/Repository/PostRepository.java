package zlawlghks.restfulcrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zlawlghks.restfulcrud.Domain.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
