package com.bandipo.blogapi.controller;

import com.bandipo.blogapi.model.Post;
import com.bandipo.blogapi.model.User;
import com.bandipo.blogapi.services.serviceImplementation.PostServiceImpl;
import com.bandipo.blogapi.services.serviceImplementation.UserServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {


    UserServiceImpl userService;

    PostServiceImpl postService;

    @GetMapping()
    public List<User> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @GetMapping("/{id}/posts")
    public ResponseEntity<?> getPostsByUser(@PathVariable Long id){
        List<Post> postsByUserId = postService.findPostsByUserId(id);
        return new ResponseEntity<>(postsByUserId, HttpStatus.OK);

    }

    @PostMapping("/add-new-user")
    public ResponseEntity<?> addNewUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("New User Added", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity<>("User is update", HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }
}
