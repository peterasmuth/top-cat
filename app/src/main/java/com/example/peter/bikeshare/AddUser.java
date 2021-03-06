package com.example.peter.bikeshare;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    public void submitUser(View view){

        //Takes input values from textViews and assigns them to Strings
        EditText editFirst = (EditText) findViewById(R.id.firstName);
        String firstName = editFirst.getText().toString();
        EditText editLast = (EditText) findViewById(R.id.lastName);
        String lastName = editLast.getText().toString();
        EditText editMiddle = (EditText) findViewById(R.id.middle);
        String middleName = editMiddle.getText().toString();
        EditText editEmail = (EditText) findViewById(R.id.email);
        String email = editEmail.getText().toString();


        //Takes the new Strings from above and submits them to the database in an async task (below)
        new submitToDb().execute(firstName,lastName,middleName,email);

        //Resets UI text fields
        editFirst.setText("");
        editLast.setText("");
        editMiddle.setText("");
        editEmail.setText("");
        Toast.makeText(AddUser.this,"User Added",Toast.LENGTH_LONG).show();
    }

    //This subclass implements an async task to submit the user to the database in the background
    private class submitToDb extends AsyncTask<String,Void,Void> {

        @Override
        protected Void doInBackground(String... strings) {
            User newUser = new User();

            newUser.setEmail(strings[3]);
            newUser.setMI(strings[2]);
            newUser.setFirstName(strings[0]);
            newUser.setLastName(strings[1]);

            AppDatabase.getInstance(getApplicationContext()).userDao().insertAll(newUser);
            return null;
        }


    }
}
