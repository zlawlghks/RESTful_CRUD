package zlawlghks.restfulcrud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zlawlghks.restfulcrud.Domain.Post;
import zlawlghks.restfulcrud.Repository.PostRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;



    private static List<Post> post = new ArrayList<>();
    private static int postCount = 0;




    // 게시글 목록 조회
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    // 게시글 상세 조회
    public Post findOne(Integer id) {
        for (Post posts : post) {
            if (posts.getId() == id) {
                return posts;
            }
        }
        return null;
    }

    // 게시글 생성
    public Post save(Post posts) {
        if (posts.getId() == null) {
            posts.setId(++postCount);
        }
        postRepository.save(posts);
        post.add(posts);
        return posts;
    }

    // 게시물 수정
    public Post updatePost(Integer id, Post posts) {
        for (Post storedPost : post) {
            if (storedPost.getId() == id) {
                storedPost.setBoardName(posts.getBoardName());
                storedPost.setDescription(posts.getDescription());

                postRepository.save(storedPost);
                return storedPost;
            }
        }
        return null;
    }


    // 게시글 삭제
    public Post deleteById(int id) {
        Iterator<Post> iterator = post.iterator();

        while (iterator.hasNext()) {
            Post posts = iterator.next();

            if (posts.getId() == id) {
                postRepository.delete(posts);
                iterator.remove();
                return posts;
            }
        }
        return null;
    }
}
