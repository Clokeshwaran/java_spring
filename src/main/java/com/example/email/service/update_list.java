//package com.example.email.service;
//
//import com.example.email.confic.Passwordconfig;
//import com.example.email.entity.token_entity;
//import com.example.email.entity.user_entity;
//import com.example.email.repo.user_repo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//public class update_list {
//
//    @Autowired
//    private user_repo user_repo;
//    @Autowired
//    Passwordconfig passwordconfig;
//
//    public  ResponseEntity update_user(user_entity user){
//
//        if (user_repo.findByEmail(user.getEmail()) != null) {
//
//            //password hashing
//            user.setPassword(passwordconfig.password(user.getPassword()));
//
//            user_repo.save(user);
//
//
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body("update successfully");
//        }
//        else
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("update failed");
//    }
//
//}
