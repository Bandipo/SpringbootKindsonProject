package com.bandipo.blogapi.services;

import com.bandipo.blogapi.model.User;

public interface UserService  {
   User findUserByPostId(Long postId);
   void addUser (User user);
   void updateUser(User user);


    void deleteUser(long id);
}
