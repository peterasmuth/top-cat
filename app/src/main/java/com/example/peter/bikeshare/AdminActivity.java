package com.example.peter.bikeshare;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

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
    //This portion of the code would pull the first entry of the TABLE users and put the first and last name in a textView
    /*public void refresh(View view){
        new findFirst().execute();
    }

    private class findFirst extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            int userCount = AppDatabase.getInstance(getApplicationContext()).userDao().userCount();
            TextView sqlTextView = findViewById(R.id.sqlOutput);

            if(userCount >=1 ) {
                User firstUser;
                firstUser = AppDatabase.getInstance(getApplicationContext()).userDao().findFirst();
                String output = firstUser.getFirstName() + " " + firstUser.getLastName();
                sqlTextView.setText(output);
                return null;
            }else{
                sqlTextView.setText("No users");
                return null;
            }
        }

    }*/

    public void clearUsers(View view){
        new clearList().execute();
    }

    private class clearList extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            AppDatabase.getInstance(getApplicationContext()).userDao().deleteAll();
            return null;
        }
    }


}
