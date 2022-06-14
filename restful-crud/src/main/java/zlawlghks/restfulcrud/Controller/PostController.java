package zlawlghks.restfulcrud.Controller;

import org.hibernate.EntityMode;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zlawlghks.restfulcrud.Domain.Post;
import zlawlghks.restfulcrud.PostNotFoundException;
import zlawlghks.restfulcrud.Repository.PostRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PostController {

    private PostRepository postRepository;

    // 게시글 목록 조회
    @GetMapping("/posts")
    public List<Post> retrieveAllPost() {
        return postRepository.findAll();
    }

    // 게시글 상세 조회
    @GetMapping("/posts/{id}")
    public EntityModel<Post> retrievePost(@PathVariable int id) {
        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent()) {
            throw new PostNotFoundException(String.format("ID{%s} not found", id));
        }

        EntityModel<Post> entityModel = EntityModel.of(post.get());
        WebMvcLinkBuilder linkto = linkTo(methodOn(this.getClass()).retrieveAllPost());
        entityModel.add(linkto.withRel("all-posts"));

        return entityModel;
    }

    // 게시글 생성
    @PostMapping("/posts/{id}")
    public Post createPost(@PathVariable int id, @RequestBody Post post) {
        return postRepository.save(post);
    }

}
