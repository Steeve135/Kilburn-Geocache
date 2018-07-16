package com.example.kilburncache.kilburncache;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class register extends AppCompatActivity {

    // Creates the register activity and links it to the register.xml layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    } // onCreate

    // A method to return to the login page and display a message saying that the user has successfully registered.
    // This will be changed once we work out how to do all the database bullshit
    public void registered(View v){
        startActivity(new Intent(register.this, MainActivity.class));

        // Creates the message
        Context context = getApplicationContext();
        CharSequence text = "You are now registered";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    } //registered
}
