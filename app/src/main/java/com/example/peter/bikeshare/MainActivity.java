package com.example.peter.bikeshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BikeShareMain fleet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToUser(View view){
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }

    public void goToAdmin(View view){
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
}
