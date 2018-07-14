package com.example.kilburncache.kilburncache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Creates the Main activity and links it to the activity_main.xml layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } // onCreate

    // Makes it so that the register page opens when you click on the word register.
    public void register(View v){
      startActivity(new Intent(MainActivity.this, register.class));

    } // onClick
    // Opens the main page when you log in.
    public void login(View v) {
        startActivity(new Intent(MainActivity.this, HomePage.class));
    }

} // MainActivity

