package com.example.email.service;


import com.example.email.entity.login_entity;
import com.example.email.entity.user_entity;
import com.example.email.repo.user_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class login_service {
//
//
//
//    @Autowired
//    private Service_method service_method;
//    @Autowired
//    private user_repo user_repo;
//
//    public ResponseEntity<String> login(login_entity log){
//        String pass= service_method.password(log.getPassword());
//        user_entity user=user_repo.findbyemailandpassword(log.getEmail(),log.getPassword());
//        if(user!=null)
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body("log in successfully");
//        else
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("log in fail");
//    }
//
//
//
}
