package com.example.peter.bikeshare;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.arch.persistence.room.Room.databaseBuilder;

public class MainActivity extends AppCompatActivity {


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
