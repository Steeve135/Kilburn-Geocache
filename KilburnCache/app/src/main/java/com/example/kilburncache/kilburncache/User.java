package com.example.kilburncache.kilburncache;

// The class for everything user related
public class User {

    public String id;
    public String userName;
    public String email;
    public String password;
    public int score;

    // Constructor, the score is initially 0
    public User(String id, String userName, String email,String password, int score) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.score = score;
    } // User

} // User class
