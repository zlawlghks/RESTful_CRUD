package zlawlghks.restfulcrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zlawlghks.restfulcrud.Domain.Post;
import zlawlghks.restfulcrud.PostNotFoundException;
import zlawlghks.restfulcrud.Repository.PostRepository;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    @GetMapping("/posts/{id}")
    public EntityModel<Post> retreievePost(@PathVariable int id) {
        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent()) {
            throw new PostNotFoundException(String.format("ID[%s] not found", id));
        }
        EntityModel<Post> entityModel = EntityModel.of(post.get());
        WebMvcLinkBuilder linkto = linkTo(methodOn(this.getClass()).retrieveAllPost());
        entityModel.add(linkto.withRel("all-posts"));
        return entityModel;
    }

    // 게시물 생성

    // 게시물 수정

    // 게시물 삭제
}
