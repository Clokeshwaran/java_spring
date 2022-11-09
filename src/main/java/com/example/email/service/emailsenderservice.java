package com.example.email.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailsenderservice {



    @Autowired
    private JavaMailSender mailsender;

    public  void  sendemail(String toemail,String body,String subject){
        SimpleMailMessage message= new SimpleMailMessage();

        message.setFrom("lokeshnrm07@gmail.com");
        message.setTo(toemail);
        message.setText("https://localhost:8080"+body);
        message.setSubject(subject);


        mailsender.send(message);


    }
}
