package com.example.email.confic;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class Passwordconfig {

    //password

    public String password(String pass){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        return bCryptPasswordEncoder.encode(pass);

    }
}
