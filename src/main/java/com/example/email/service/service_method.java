package com.example.email.service;


//import com.example.email.entity.token_entity;
import com.example.email.entity.login_entity;
import com.example.email.entity.token_entity;
import com.example.email.jwt.Token;
//import com.example.email.repo.token_repo;
//import com.example.email.repo.token_repo;
import com.example.email.repo.token_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import com.example.email.entity.user_entity;
import com.example.email.repo.user_repo;




@Service
public class service_method {
//
    @Autowired
    private user_repo user_repo;

    @Autowired
    private emailsenderservice eservice;

    @Autowired
    private token_repo token_repos;


    public List<user_entity> getdata() {
        return user_repo.findAll();
    }


//post get method
    public ResponseEntity<?> create(user_entity lok){
        if (user_repo.findByEmail(lok.getEmail()) == null) {
            //hash
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
            lok.setPassword( bCryptPasswordEncoder.encode(lok.getPassword()));

            token_entity token=new token_entity(lok);
            String link=token.getCon_token();

            eservice.sendemail(lok.getEmail(),
                    link,
                    "Account verification email");

            user_repo.save(lok);
            token_repos.save(token);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("added successfully");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user is alredy exists");
    }



    //verification method
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






