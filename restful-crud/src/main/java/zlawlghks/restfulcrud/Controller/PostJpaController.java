package zlawlghks.restfulcrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zlawlghks.restfulcrud.Domain.Post;
import zlawlghks.restfulcrud.Repository.PostRepository;

import java.util.List;

@RestController
public class PostJpaController {
    @Autowired
    private PostRepository postRepository;

    // 게시물 목록 조회
    @GetMapping("/posts")
    public List<Post> retrieveAllPost() {
        return postRepository.findAll();
    }
    // 게시물 상세 조회

    // 게시물 생성

    // 게시물 수정

    // 게시물 삭제
}
