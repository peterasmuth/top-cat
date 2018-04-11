package com.example.peter.bikeshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddUser extends AppCompatActivity {

    static int userCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    public void submitUser(){

        EditText editFirst = (EditText) findViewById(R.id.firstName);
        String firstName = editFirst.getText().toString();

        EditText editLast = (EditText) findViewById(R.id.lastName);
        String lastName = editLast.getText().toString();

        EditText editMiddle = (EditText) findViewById(R.id.middle);
        String middleName = editMiddle.getText().toString();

        EditText editEmail = (EditText) findViewById(R.id.email);
        String email = editEmail.getText().toString();

        User newUser = new User();

        newUser.setUser_id(userCount);
        userCount++;
        newUser.setEmail(email);
        newUser.setMI(middleName);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        AppDatabase.getInstance(getApplicationContext()).userDao().insertAll(newUser);
    }
}
