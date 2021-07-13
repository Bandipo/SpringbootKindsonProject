package com.bandipo.blogapi.services.serviceImplementation;

import com.bandipo.blogapi.model.Post;
import com.bandipo.blogapi.model.User;
import com.bandipo.blogapi.repositories.PostRepository;
import com.bandipo.blogapi.repositories.UserRepository;
import com.bandipo.blogapi.services.UserService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    UserRepository userRepository;

    PostRepository postRepository;


    public List<User> getAllUsers() {
        Iterable<User> all = userRepository.findAll();
        return (List<User>) all;
    }

    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);


    }


    @Override
    public User findUserByPostId(Long postId) {
        Optional<Post> postById = postRepository.findPostById(postId);
        Post post = postById.orElseThrow(RuntimeException::new);
        return post.getUser();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


}
