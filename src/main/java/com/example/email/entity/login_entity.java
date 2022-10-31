package com.example.email.entity;

import org.springframework.context.annotation.Configuration;




@Configuration
public class login_entity {
    private String Email;
    private  String Password;

    public login_entity(String email, String password) {
        Email = email;
        Password = password;
    }

    public login_entity() {

    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
