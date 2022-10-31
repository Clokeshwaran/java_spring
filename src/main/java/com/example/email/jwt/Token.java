package com.example.email.jwt;

import com.example.email.entity.user_entity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Token {

    public String generste_jwt(user_entity user){

        //claims
        Claims clai= Jwts.claims()
                .setId(user.getEmail().toString())
                .setIssuer(user.getPassword().toString());

        //generate jwt

        return Jwts.builder().setClaims(clai).compact();
    }
}
