package com.example.kilburncache.kilburncache;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    EditText editTextEmail;
    EditText editTextPassword;


    // Creates the Main activity and links it to the activity_main.xml layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DatabaseHelper(this);
        initViews();

    } // onCreate


    // Opens the main page when you log in.
    public void login(View v) {
        // check if the input is correct
        if (validate()){
          String Email = editTextEmail.getText().toString();
          String Password = editTextPassword.getText().toString();

          // Authenticate the user.
          User currentUser = dbHelper.Authenticate(new User(null, Email, Password, 0));

            if (currentUser != null) {
                startActivity(new Intent(MainActivity.this, HomePage.class));
                finish();
            }else{
                Context context = getApplicationContext();
                CharSequence text = "Log in failed";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } //else
        }
    } //login

    // This method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
    } // initViews

    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Context context = getApplicationContext();
            CharSequence text = "Please enter a valid email";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        } else if (Password.isEmpty()) {
            valid = false;
            Context context = getApplicationContext();
            CharSequence text = "Please enter a valid password";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            valid = true;
        }
        return valid;
    }


    // Makes it so that the register page opens when you click on the word register.
    public void register(View v){
        startActivity(new Intent(MainActivity.this, register.class));
    } // register


} // MainActivity

