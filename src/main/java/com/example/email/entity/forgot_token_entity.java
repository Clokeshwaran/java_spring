package com.example.email.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity(name = "forgot_token")
public class forgot_token_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long token_id;

    private String token;

    private Date created_date;

    private String user_id;

    public forgot_token_entity(String email) {
        this.token = UUID.randomUUID().toString();
        this.created_date = new Date();
        this.user_id = email;
    }

    public forgot_token_entity() {

    }

    public String getCon_token() {
        return token;
    }

    public void setCon_token(String con_token) {
        this.token = con_token;
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

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
