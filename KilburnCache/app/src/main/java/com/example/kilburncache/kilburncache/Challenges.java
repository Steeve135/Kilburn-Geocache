package com.example.kilburncache.kilburncache;

import java.util.ArrayList;
import java.util.List;

public class Challenges {

    String name;
    String location;

    Challenges(String name, String location){
        this.name = name;
        this.location = location;
    }

    private List<Challenges> challenges;

    private void initializeData(){
        challenges = new ArrayList<>();
        challenges.add(new Challenges("Challenge 1", "Location 1"));
        challenges.add(new Challenges("Challenge 2", "Location 2"));
        challenges.add(new Challenges("Challenge 3", "Location 3"));
    }
}
