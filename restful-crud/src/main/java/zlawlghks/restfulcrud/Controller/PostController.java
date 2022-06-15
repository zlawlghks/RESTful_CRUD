package zlawlghks.restfulcrud.Controller;

import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import zlawlghks.restfulcrud.Domain.Post;
import zlawlghks.restfulcrud.PostNotFoundException;
import zlawlghks.restfulcrud.Service.PostService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PostController {
    private PostService service;
    public PostController(PostService service){
        this.service = service;
    }

    // 게시글 목록 조회
    @GetMapping("/posts")
    public List<Post> retrieveAllPost() {
        return service.findAll();
    }

    // 게시글 상세 조회
    @GetMapping("/posts/{id}")
    public EntityModel<Post> retrievePost(@PathVariable int id) {
        Post post = service.findOne(id);

        if (post == null) {
            throw new PostNotFoundException(String.format("ID{%s} not found", id));
        }

        EntityModel<Post> entityModel = EntityModel.of(post);
        WebMvcLinkBuilder linkto = linkTo(methodOn(this.getClass()).retrieveAllPost());
        entityModel.add(linkto.withRel("all-posts"));

        return entityModel;
    }

    // 게시글 생성
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post posts = service.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(("/{id}"))
                .buildAndExpand(post.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // 게시글 수정
    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable int id, @RequestBody Post post) {
        Post updatePost = service.updatePost(id, post);

        if (updatePost == null) {
            throw new PostNotFoundException(String.format("ID[%s] not found", post.getId()));
        }
    }


    // 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable int id) {
        Post post = service.deleteById(id);

        if (post == null) {
            throw new PostNotFoundException(String.format("ID[%s] not found", id));
        }
    }

}
