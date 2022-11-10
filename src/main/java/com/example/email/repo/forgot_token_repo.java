package com.example.email.repo;

import com.example.email.entity.forgot_token_entity;
import com.example.email.entity.token_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface forgot_token_repo extends JpaRepository<forgot_token_entity,Integer> {

//     forgot_token_entity findBycon_token(String con_token);
    public default forgot_token_entity findBycon_token(String con_token) {
        List<forgot_token_entity> all = findAll();
        for (forgot_token_entity token : all) {
            if (token.getCon_token().equals(con_token)) {
                return token;
            }
        }
        return null;
    }
    //--------------




    //-------------
//    default String findByEmail(String token) {
//        List<forgot_token_entity> all = findAll();
//        for (forgot_token_entity user : all) {
//            if (user.getCon_token().equals(token)) {
//                return user.getUser_id();
//            }
//        }
//        return null;
//    }
}
