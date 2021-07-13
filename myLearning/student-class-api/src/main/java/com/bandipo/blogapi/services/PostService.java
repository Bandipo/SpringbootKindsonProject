package com.bandipo.blogapi.services;

import com.bandipo.blogapi.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
     List<Post> findAll();
     Optional<Post> findById(Long id);
     List<Post> findPostsByUserId(Long id);
     void  addPost(Post post);

    void updatePost(Post post);

    void deletePost(long id);
}
