package com.example.email.entity;

import com.example.email.jwt.Token;
import com.example.email.repo.token_repo;
import com.example.email.service.service_method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "token")
public class token_entity {

//    @Autowired
//    private service_method ser;

//    @Autowired
//    private token_repo token_repo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long token_id;

    private String con_token;

    private Date created_date;

    private String user_id;


    public token_entity(user_entity user) {
        this.created_date = new Date();
        con_token= UUID.randomUUID().toString();
        this.user_id = user.getEmail();
    }



    public token_entity() {

    }

    public long getToken_id() {
        return token_id;
    }

    public void setToken_id(long token_id) {
        this.token_id = token_id;
    }

    public String getCon_token() {
        return con_token;
    }

    public  void setCon_token(String con_token) {
        this.con_token = con_token;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = String.valueOf(user_id);
    }
}
