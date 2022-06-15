package zlawlghks.restfulcrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import zlawlghks.restfulcrud.Domain.Post;
import zlawlghks.restfulcrud.PostNotFoundException;
import zlawlghks.restfulcrud.Repository.PostRepository;

import javax.validation.Valid;
import java.net.URI;
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
    public EntityModel<Post> retrievePost(@PathVariable int id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            throw new PostNotFoundException(String.format("ID[%s] not found", id));
        }
        EntityModel<Post> entityModel = EntityModel.of(post.get());
        WebMvcLinkBuilder linkto = linkTo(methodOn(this.getClass()).retrieveAllPost());
        entityModel.add(linkto.withRel("all-posts"));

        return entityModel;
    }

    // 게시물 생성
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // 게시물 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (!optionalPost.isPresent()) {
            throw new PostNotFoundException(String.format("ID{%s} not found", id));
        }
        Post storedPost = optionalPost.get();
        storedPost.setBoardName(post.getBoardName());
        storedPost.setDescription(post.getDescription());

        Post updatePost = postRepository.save(storedPost);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatePost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // 게시물 삭제
    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable int id) {
        postRepository.deleteById(id);
    }
}
