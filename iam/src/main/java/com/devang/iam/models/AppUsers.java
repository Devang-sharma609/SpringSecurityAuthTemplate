package com.devang.iam.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppUsers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uId;
    private String username;
    private String password;
    
    public AppUsers(){}

    public AppUsers(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public int getuId() {
        return uId;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}