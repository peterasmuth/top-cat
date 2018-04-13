package com.example.peter.bikeshare;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

public class idLocation {

        @ColumnInfo(name = "lat")
        private double lat;

        @ColumnInfo(name = "lon")
        private double lon;

        @PrimaryKey(autoGenerate = true)
        private int bike_id;

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public int getBike_id() {
        return bike_id;
    }

    public double getLon() {
        return lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
