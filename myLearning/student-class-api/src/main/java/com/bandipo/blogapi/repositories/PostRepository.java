package com.bandipo.blogapi.repositories;

import com.bandipo.blogapi.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
    Optional<Post> findPostById (Long id);
    List<Post> findPostsByUserId(Long id);
}
