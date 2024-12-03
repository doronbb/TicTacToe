package com.example.TicTacToe;

public class User
{
    private String email;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    // Constructor to initialize the user object
    public User(String email) {
        this.email = email;
    }

    // Getters and setters for user attributes
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
