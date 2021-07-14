package com.springsecurity.KindsonSpringSecurity.auth;

import com.springsecurity.KindsonSpringSecurity.entity.User;

import com.springsecurity.KindsonSpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(userName)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("%s in not found", userName)));
        return new MyUserDetails(user);//or user.map(MyUserDetails::new)
    }
}
