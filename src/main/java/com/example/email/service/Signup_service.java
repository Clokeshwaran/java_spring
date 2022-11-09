package com.example.email.service;

import com.example.email.confic.Passwordconfig;
import com.example.email.entity.token_entity;
import com.example.email.entity.user_entity;
import com.example.email.repo.token_repo;
import com.example.email.repo.user_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Signup_service {//implements UserDetailsService {
    @Autowired
    private user_repo user_repo;
    @Autowired
    private token_repo token_repos;


    @Autowired
    private emailsenderservice eservice;

    @Autowired
    Passwordconfig passwordconfig;

    public List<user_entity> getdata() {
        return user_repo.findAll();
    }


//post get method
    public ResponseEntity<?> create(user_entity lok){//}, user_entity user) {
        if (user_repo.findByEmail(lok.getEmail()) == null) {

            //password hashing
            lok.setPassword(passwordconfig.password(lok.getPassword()));

            token_entity token=new token_entity(lok);
            String link=token.getCon_token();

            //mail sent to the user email id
            eservice.sendemail(lok.getEmail(),
                    "/verify/"+link,
                    "Account verification email");
            user_repo.save(lok);
            token_repos.save(token);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("added successfully");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user is alredy exists");
    }


//user validation
    public ResponseEntity verify(String token){

      if(token_repos.findBycon_token(token)!=null)
        {
            String email=token_repos.findByEmail(token);
            user_entity user=user_repo.findByEmail(email);
            user.setIs_enabled(true);
            token_repos.delete(token_repos.findBycon_token(token));
            user_repo.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
       else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found!");
    }


}






