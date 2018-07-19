package com.example.kilburncache.kilburncache;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// The class to handle all the registration shit
public class register extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;

    DatabaseHelper dbHelper;



    // Creates the register activity and links it to the register.xml layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        dbHelper = new DatabaseHelper(this);
        initViews();


    } // onCreate

    // A method to return to the login page and display a message saying that the user has successfully registered.
    // This will be changed once we work out how to do all the database bullshit
    public void registered(View v){
        if (validate()){
            String UserName = editTextUserName.getText().toString();
            String Email = editTextEmail.getText().toString();
            String Password = editTextPassword.getText().toString();

            // Check to see if the email is already in the db
            if (!dbHelper.isEmailExists(Email)) {
                dbHelper.addUser(new User(null, UserName, Email, Password, 0));
                Context context = getApplicationContext();
                CharSequence text = "User created successfully!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                startActivity(new Intent(register.this, MainActivity.class));

            }else{
                Context context = getApplicationContext();
                CharSequence text = "A user already exists with the same email";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        }


    } //registered

    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.Email);
        editTextPassword = (EditText) findViewById(R.id.Password);
        editTextUserName = (EditText) findViewById(R.id.Username);
    }

    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields
        String UserName = editTextUserName.getText().toString();
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        // Validate the username
        if (UserName.isEmpty()){
            valid = false;
            Context context = getApplicationContext();
            CharSequence text = "Please enter a valid username";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else{
            valid = true;
        }

        // Validate the email address
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Context context = getApplicationContext();
            CharSequence text = "Please enter a valid email";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            valid = true;
        }

        // validate the password
        if (Password.isEmpty()) {
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

    } // validate
} // register class
