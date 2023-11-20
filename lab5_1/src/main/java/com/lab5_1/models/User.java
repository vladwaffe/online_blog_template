package com.lab5_1.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String passwd;
    private Boolean login;

    public User() {}

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public User(Long id){
        this.id = id;
    }


    public User(String email, String password) {
        this.email = email;
        this.passwd = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return passwd;
    }

    public void setPassword(String password) {
        this.passwd = password;
    }
}

