package zlawlghks.restfulcrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zlawlghks.restfulcrud.Domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
