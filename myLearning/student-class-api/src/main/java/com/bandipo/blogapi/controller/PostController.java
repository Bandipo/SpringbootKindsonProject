package com.bandipo.blogapi.controller;

import com.bandipo.blogapi.model.Post;
import com.bandipo.blogapi.model.User;
import com.bandipo.blogapi.services.serviceImplementation.PostServiceImpl;
import com.bandipo.blogapi.services.serviceImplementation.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {


    private final PostServiceImpl postService;

    private final UserServiceImpl userService;

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping("/{id}/user")
    public ResponseEntity<?> getUserByPostId(@PathVariable Long id){
        User userByPostId = userService.findUserByPostId(id);
        return new ResponseEntity<>(userByPostId, HttpStatus.OK);
    }

    @GetMapping("/user/{id}/posts")
    public ResponseEntity<?> getPostsByUserId(@PathVariable Long id){
        List<Post> postsByUserId = postService.findPostsByUserId(id);

        return new ResponseEntity<>(postsByUserId,HttpStatus.OK);
    }


    @PostMapping("/add-new-post")
    public ResponseEntity<?> addNewPost(@RequestBody Post post ){
        postService.addPost(post);
        return new ResponseEntity<>("New Post Added", HttpStatus.OK);
    }


    @PutMapping("/posts/{id}/update")
    public ResponseEntity<?> updatePost(@RequestBody Post post){
        postService.updatePost(post);
        return new ResponseEntity<>("Post is updated", HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}/delete")
    public ResponseEntity<?> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("post deleted", HttpStatus.OK);
    }

}
