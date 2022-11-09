package com.example.email.controller;

import com.example.email.entity.user_entity;
import com.example.email.service.Signup_service;
//import com.example.email.service.forgot_password_ser;
import com.example.email.service.login_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class controller {

    @Autowired
    private Signup_service ser;
    @Autowired
    private login_service loginService;
//    @Autowired
//    private forgot_password_ser forgot_password;

    @GetMapping("/home")
    public String home() {
        return "welcome to home page";
    }

    @GetMapping("/get")
    public List<user_entity> get_usre_data() {
        return ser.getdata();
    }

    //new user create api
    @PostMapping("/signup")
    public ResponseEntity create(@Valid @RequestBody user_entity lok) {
        return ser.create(lok);
    }

    //validation api
    @RequestMapping(value = "/verify/{token}",method = RequestMethod.GET)
    public ResponseEntity<String> verify(@PathVariable String token)
    {
        return ser.verify(token);
    }




//    @RequestMapping(value = "/login1",method = RequestMethod.GET)
//    public ResponseEntity<APIRespo> login(@RequestBody login_entity log)
//    {
//       return loginService.login(log);
//    }

}

