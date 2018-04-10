package com.example.peter.bikeshare;

import java.util.ArrayList;

public class BikeShareMain {

    private ArrayList<Bike> bikes;

    public BikeShareMain(){
        bikes = new ArrayList<Bike>();
    }

    public void addToFleet(Bike b){
        bikes.add(b);
    }

    public void removeBike(Bike b){
        bikes.remove(b);
    }

}
