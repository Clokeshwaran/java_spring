package com.example.email.service;

import com.example.email.entity.custom_user_entity;
import com.example.email.entity.user_entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class customuser implements UserDetailsService {

    @Autowired
    private com.example.email.repo.user_repo user_repo;
    @Autowired
    emailsenderservice eservice;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        user_entity user = user_repo.findByEmail(username);
//        user_entity user = user_repo.findByname(username);
        if(user==null)
            throw new UsernameNotFoundException("user not fount ");

        return new custom_user_entity(user);
    }
}
