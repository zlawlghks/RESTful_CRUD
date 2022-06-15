package zlawlghks.restfulcrud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zlawlghks.restfulcrud.Domain.Post;
import zlawlghks.restfulcrud.PostNotFoundException;
import zlawlghks.restfulcrud.Repository.PostRepository;

import java.util.*;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    // 게시글 목록 조회
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    // 게시글 상세 조회
    public Post findOne(Integer id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new PostNotFoundException(String.format("ID{%s} not found", id));
        } else {
            return post.get();
        }
    }

    // 게시글 생성
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    // 게시물 수정
    public void updatePost(Integer id, Post post) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException(String.format("ID[%s] not found", post.getId()));
        } else {
            Post savedPost = optionalPost.get();
            savedPost.setBoardName(post.getBoardName());
            savedPost.setDescription(post.getDescription());
            postRepository.save(savedPost);
        }
    }


    // 게시글 삭제
    public void deletePost(Integer id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException(String.format("ID[%s] not found", id));
        } else {
            Post post = optionalPost.get();
            postRepository.delete(post);
        }
    }
}
