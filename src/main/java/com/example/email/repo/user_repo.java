package com.example.email.repo;

import com.example.email.entity.user_entity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface user_repo extends JpaRepository<user_entity,String> {
  default user_entity findByEmail(String Email) {
      List<user_entity> all = findAll();
      for (user_entity user : all) {
          if (user.getEmail().equals(Email)) {
              return user;
          }
      }
      return null;
  }

//  user_entity findByname(String name);


    default user_entity findbyemailandpassword(String Email, String password) {
        List<user_entity> all = findAll();
        for (user_entity user : all) {
            if (user.getEmail().equals(Email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}










