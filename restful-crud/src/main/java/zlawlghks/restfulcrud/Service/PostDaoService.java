package zlawlghks.restfulcrud.Service;

import org.springframework.stereotype.Service;
import zlawlghks.restfulcrud.Domain.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class PostDaoService {
    private static List<Post> post = new ArrayList<>();

    private static int postCount = 3;

    static {
        post.add(new Post(1, "jh1", "good boy1", new Date()));
        post.add(new Post(2, "jh2", "good boy2", new Date()));
        post.add(new Post(3, "jh3", "good boy3", new Date()));
    }

    // 게시글 목록 조회
    public List<Post> findAll() {
        return post;
    }

    // 게시글 상세 조회
    public Post findOne(int id) {
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
        post.add(posts);
        return posts;
    }

    // 게시물 수정
    public Post updatePost(int id, Post posts) {
        for (Post storedPost : post) {
            if (storedPost.getId() == id) {
                storedPost.setBoardName(posts.getBoardName());
                storedPost.setDescription(posts.getDescription());

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
                iterator.remove();
                return posts;
            }
        }
        return null;
    }
}
