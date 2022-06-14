package zlawlghks.restfulcrud.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zlawlghks.restfulcrud.Domain.Post;
import zlawlghks.restfulcrud.Repository.PostRepository;

import java.util.List;

@RestController
public class PostController {

    private PostRepository postRepository;

    // 게시글 목록 조회
    @GetMapping
    public List<Post> retrieveAllPost() {
        return postRepository.findAll();
    }
}
