package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;


@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //private Long ownerId;

    @NaturalId
    private String title;
    private String anons, full_text;
    private int view;

    public Post() {}
    /*public Post(String title, String anons, String full_text, Long ownerId) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
        this.ownerId = ownerId;
    }*/
    public Post(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}