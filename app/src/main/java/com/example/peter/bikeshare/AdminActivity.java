package com.example.peter.bikeshare;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


    }

    public void goToAddBike(View view) {
        Intent intent = new Intent(this, AddBike.class);
        startActivity(intent);
    }

    public void goToAddUser(View view) {
        Intent intent = new Intent(this, AddUser.class);
        startActivity(intent);
    }

    public void goToMap(View view) {
        Intent intent = new Intent(this, MapsTest.class);
        startActivity(intent);
    }

    public void refresh(View view){
        new findFirst().execute();
    }

    private class findFirst extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            TextView sqlTextView = findViewById(R.id.sqlOutput);
            User firstUser;
            firstUser = AppDatabase.getInstance(getApplicationContext()).userDao().findFirst();

            String output = firstUser.getFirstName()+" "+firstUser.getLastName();
            sqlTextView.setText(output);
            return null;
        }

    }


}
