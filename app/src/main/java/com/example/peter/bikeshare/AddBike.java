package com.example.peter.bikeshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AddBike extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike);
    }

    public void addBike(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        Bike bike = new Bike(message);


    }
}
