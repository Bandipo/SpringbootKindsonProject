package com.bandipo.blogapi.repositories;

import com.bandipo.blogapi.exceptions.ResourceNotFoundException;
import com.bandipo.blogapi.model.Location;
import com.bandipo.blogapi.model.Post;
import com.bandipo.blogapi.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.* ;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository ;

    @Autowired
    private UserRepository userRepository;

    private User user;
    private Post post;
    private Location location;

    @BeforeEach
    void setUp(){





    }



    @Test
    void ShouldFindPostsByUserId() {
        //Given
        long id = 1;
        Optional<User> userOptional = userRepository.findById(id);

        User user = userOptional.orElseThrow(()->  new ResourceNotFoundException("User not found"));

        //When

        List<Post> posts = user.getPosts();


        //Then

        assertFalse(posts.isEmpty());


    }
}