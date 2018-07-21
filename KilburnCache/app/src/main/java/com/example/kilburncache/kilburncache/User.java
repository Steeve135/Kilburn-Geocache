package com.example.kilburncache.kilburncache;

// The class for everything user related
public class User {

    public String userName;
    public String email;
    public String password;
    public int score;

    // Constructor, the score is initially 0
    public User(String userName, String email,String password, int score) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.score = score;
    } // User

} // User class
