package com.example.email.service;

import com.example.email.confic.Passwordconfig;
import com.example.email.entity.forgot_token_entity;
import com.example.email.entity.user_entity;
import com.example.email.repo.forgot_token_repo;
import com.example.email.repo.user_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class forgot_password_ser {

    @Autowired
    com.example.email.repo.user_repo user_repo;
    @Autowired
    Passwordconfig password;
    @Autowired
    private emailsenderservice eservice;
    @Autowired
    private forgot_token_repo for_token_repos;
    @Autowired
    Passwordconfig passwordconfig;


    //--------

    public boolean find(String email){
        if (user_repo.findByEmail(email) != null )
         return true;

        return false;
    }

    public String forgot(String email){
        if(find(email)){
//            return forgot_password.forgot(email);

            forgot_token_entity token=new forgot_token_entity(email);
            String link=token.getCon_token();
            eservice.sendemail(email,
                    "/forgot/"+link,
                    "Forgot password link: ");
            //forgot_token_entity tt=new forgot_token_entity();
            for_token_repos.save(token);

            return "forgot Mail is send";
        }
        return "Enter the valid user name";

    }


    //-----

    public ResponseEntity verify_password(String token, String pass){

        if(for_token_repos.findBycon_token(token)!=null)
        {
            forgot_token_entity email=for_token_repos.findBycon_token(token);

//            String email= String.valueOf(for_token_repos.findBycon_token(token));//findByEmail(token);
            user_entity user=user_repo.findByEmail(email.getUser_id());

            user.setPassword(password.password(pass));

            for_token_repos.delete(for_token_repos.findBycon_token(token));
            user_repo.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found!");
    }


    //----------------------------------------------------------------------------
    //update_user_list

    public  ResponseEntity update_user(user_entity user){

//        String user_pass = user_repo.findByEmail(user.getEmail()).getPassword();

        if (user_repo.findByEmail(user.getEmail()) != null) {

            //password hashing
//            user.setPassword(passwordconfig.password(user.getPassword()));

//            user.setPassword(user_pass);
            user_repo.save(user);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("update successfully");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("update failed\n please" +
                    "Enter the valid email id");
    }


}
