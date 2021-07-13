package com.bandipo.blogapi.services.serviceImplementation;

import com.bandipo.blogapi.model.Post;
import com.bandipo.blogapi.model.User;
import com.bandipo.blogapi.repositories.PostRepository;
import com.bandipo.blogapi.repositories.UserRepository;
import com.bandipo.blogapi.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;

     private final UserRepository userRepository;

    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findPostsByUserId(Long id){
       Optional<User> userById = userRepository.findById(id);
       User user = userById.orElseThrow(RuntimeException::new);
       return user.getPosts();
    }

    @Override
    public void addPost(Post post){
        postRepository.save(post);

    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }


}
