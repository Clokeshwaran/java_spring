package com.example.email.controller;


import com.example.email.service.Signup_service;
import com.example.email.service.forgot_password_ser;
import com.example.email.service.login_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class forgot {


    @Autowired
    private Signup_service ser;
    @Autowired
    private login_service loginService;
    @Autowired
    private forgot_password_ser forgot_password;




    @PostMapping("/forgot_password")
    public String showResetPasswordForm(@RequestBody String email) {

       // if(forgot_password.find(email))
        return forgot_password.forgot(email);

        //return "Enter the valid user name";

    }



    @RequestMapping(value = "/forgot/{token}",method = RequestMethod.GET)
    public ResponseEntity<String> forgotpassword(@PathVariable String token, @RequestBody String password)
    {
        return forgot_password.verify_password(token,password);
    }
}
