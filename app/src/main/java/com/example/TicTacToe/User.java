package com.example.TicTacToe;

public class User
{
    private String email;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private String uid;

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
