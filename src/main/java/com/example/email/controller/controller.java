package com.example.email.controller;

import com.example.email.entity.login_entity;
import com.example.email.entity.user_entity;
import com.example.email.service.emailsenderservice;
import com.example.email.service.login_service;
import com.example.email.service.service_method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class controller {

    @Autowired
    private service_method ser;

    @Autowired
    private login_service login_service;

    @GetMapping("/get")
    public List<user_entity> get_usre_data() {
        return ser.getdata();
    }

//sign up api part

    @PostMapping("/post")
    public ResponseEntity create(@Valid @RequestBody user_entity lok) {
        return ser.create(lok);
    }


    @RequestMapping(value = "/verify/{token}",method = RequestMethod.GET)
    public ResponseEntity<String> verify(@PathVariable String token)
    {
        return ser.verify(token);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody login_entity log)
    {
       return login_entity.
    }

}





















//
//    @GetMapping("veify/")//+x)
//    public  String veri(){
//        return "this account is verified";
//    }


    //email sender part

//    @EventListener(ApplicationReadyEvent.class)
//    public void triggermail(){
//
//        service.sendemail("corporatemonster007@gmail.com",
//                link,
//                "this is email subject");
//
//    }


//    @GetMapping("login")
//    public void login(@RequestBody login_entity log){
//
//        logger.login_user(log);
//
//    }

//}
