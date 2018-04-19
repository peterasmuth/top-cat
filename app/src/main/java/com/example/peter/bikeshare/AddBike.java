package com.example.peter.bikeshare;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AddBike extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;
    private Integer lastBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bike);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void submitBike(View view){

        //Takes input values from textViews and assigns them to Strings
        EditText editName = (EditText) findViewById(R.id.name);
        String name = editName.getText().toString();
        EditText editlat = (EditText) findViewById(R.id.lat);
        String lat = editlat.getText().toString();
        EditText editlon = (EditText) findViewById(R.id.lon);
        String lon = editlon.getText().toString();
        EditText editGears = (EditText) findViewById(R.id.gears);
        String gears = editGears.getText().toString();

        //Determines which radio button is selected and assigns a corresponding String value
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String style = radioButton.getText().toString();


        //Takes the new Strings from above and submits them to the database in an async task (below)
        new submitToDb().execute(name,lat,lon,style,gears);

        //Resets UI text fields
        editName.setText("");
        editlat.setText("");
        editlon.setText("");
        editGears.setText("");

    }


    private class submitToDb extends AsyncTask<String,Void,Integer> {

        @Override
        protected Integer doInBackground(String... strings) {
            Bike newBike = new Bike();

            newBike.setName(strings[0]);
            newBike.setLat(strings[1]);
            newBike.setLon(strings[2]);
            newBike.setStyle(strings[3]);
            newBike.setStyle(strings[4]);

            AppDatabase.getInstance(getApplicationContext()).bikeDao().insertAll(newBike);
            lastBike = AppDatabase.getInstance(getApplicationContext()).bikeDao().count();
            return lastBike;
        }

        protected void onPostExecute(Integer lastBike){
            String toastText = "Bike " + lastBike + " added";
            Toast.makeText(AddBike.this,toastText,Toast.LENGTH_LONG).show();
        }

    }

}
