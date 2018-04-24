package com.example.peter.bikeshare;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import junit.framework.Test;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String[] entries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        new populateEntries().execute();
    }

    ////////////
    //These methods are linked to buttons on the UI to navigate to the different sub-activities
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

    public void goToTest(View view){
        Intent intent = new Intent(this, TestArea.class);
        startActivity(intent);
    }

    ////////
    //Async task to query the bike database and populate an array of Strings from the table
    private class populateEntries extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            List<Bike> allBikes = AppDatabase.getInstance(getApplicationContext()).bikeDao().getAll();
            int count = allBikes.size();
            String[] entries = new String[count];

            for(int i=0;i<count;i++){
                Bike bikeI = allBikes.get(i);
                entries[i] = "ID:"+ bikeI.getBike_id() + ":" + bikeI.getName() + " " + bikeI.getStyle() + "" + bikeI.getGears() + "-speed";
            }
            mAdapter = new MyAdapter(entries);
            mRecyclerView.setAdapter(mAdapter);
            return null;
        }

    }




}
