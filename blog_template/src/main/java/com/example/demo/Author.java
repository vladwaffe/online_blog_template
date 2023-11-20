package com.example.demo;

import java.awt.*;
import java.util.ArrayList;

public class Author {
    public static ArrayList<Author> getAuthor_list() {
        return author_list;
    }

    public void setAuthor_list(ArrayList<Author> author_list) {
        this.author_list = author_list;
    }

    static ArrayList<Author> author_list = new ArrayList();



    private ArrayList<Long> id_of_posts;
    private Long personal_id;
    private String email;

    public Author(Long personal_id, String email) {
        this.personal_id = personal_id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Author() {
    }

    public ArrayList<Long> getId_of_posts() {
        return id_of_posts;
    }

    public void setId_of_posts(ArrayList<Long> id_of_posts) {
        this.id_of_posts = id_of_posts;
    }

    public Long getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(Long personal_id) {
        this.personal_id = personal_id;
    }
}
