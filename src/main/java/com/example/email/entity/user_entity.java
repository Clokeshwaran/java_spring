package com.example.email.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "sign_in")
public class user_entity {

    @NotBlank(message = "First Name is mandatory")
    @Size(min = 5,max=10 ,message = "Enter the first name is 5 to 10 charactors")
    private String First_name;

    @NotBlank(message = "Last Name is mandatory")
    @Size(min = 5,max=10 ,message = "Enter the last name is 5 to 10 charactors")
    private String Last_name;

    @NotBlank(message = "Email address is mandatory")
    @Id
    @Email(message = "Enter the proper mail id")
    private String Email;

    @NotBlank(message = "password is mandatory")
    @Size(min = 8,message = "The password must be minimum 8 and characters ")
    private String Password;

    @NotEmpty(message = "enter the gender")
    private  String Gender;

    private Date Date_of_birth;
    private String role="user";

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private  boolean is_enabled=false;


    public user_entity(String first_name, String last_name, String email, String password, String gender, Date date_of_birth, String role) {
        First_name = first_name;
        Last_name = last_name;
        Email = email;
        Password = password;
        Gender = gender;
        Date_of_birth = date_of_birth;
        role = role;
    }

    public user_entity(boolean enabled) {
        is_enabled=enabled;

    }

    public user_entity() {

    }


//    public user_entity(String s, String lokesh, String lokesh1, String waran, String admin, int i, String male) {
//
//    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
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
        this.Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getDate_of_birth() {
        return Date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        Date_of_birth = date_of_birth;
    }

    public boolean getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean enabled) {
        this.is_enabled = enabled;
    }
}
