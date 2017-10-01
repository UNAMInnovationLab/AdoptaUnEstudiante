package com.lab.innovation.unam.adoptaunestudiante.Model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String email;
    private String imageURL;
    private float ranking;

    public User() {}

    public User(String name, String email, String imageURL, float ranking) {
        this.name = name;
        this.email = email;
        this.imageURL = imageURL;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

}
