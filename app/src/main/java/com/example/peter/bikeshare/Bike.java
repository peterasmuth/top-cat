package com.example.peter.bikeshare;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "bikes")
public class Bike {

    @PrimaryKey(autoGenerate = true)
    private int bike_id;

    @ColumnInfo(name = "lat")
    private String lat;

    @ColumnInfo(name = "lon")
    private String lon;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "style")
    private String style;

    @ColumnInfo(name = "gears")
    private int gears;


    public Bike(){}


    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public int getBike_id() {
        return bike_id;
    }

    public int getGears() {
        return gears;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }
}
