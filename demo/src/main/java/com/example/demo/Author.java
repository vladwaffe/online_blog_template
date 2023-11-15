package com.example.demo;

import java.util.ArrayList;

public class Author {
    private ArrayList<Long> id_of_posts;
    private Long personal_id;

    public Author(Long personal_id) {
        this.personal_id = personal_id;
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
