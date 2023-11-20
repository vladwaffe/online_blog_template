package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class login_user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public login_user(String login_Email) {
        email = login_Email;
    }

    private String email;
}
