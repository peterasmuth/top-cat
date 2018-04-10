package com.example.peter.bikeshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
}
