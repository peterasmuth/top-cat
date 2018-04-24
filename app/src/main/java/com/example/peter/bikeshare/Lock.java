package com.example.peter.bikeshare;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//Creates a sql table named "locks"
@Entity(tableName = "locks")
public class Lock {

    //Defines the columns of the table
    @PrimaryKey(autoGenerate = true)
    private int lockID;

    @ColumnInfo(name = "name")
    private String lockName;

    @ColumnInfo(name = "paired_bike")
    private int bikeID;


    public Lock(){}

    //Getters and setters for each field
    public void setLockID(int lock_id) {
        this.lockID = lock_id;
    }

    public void setLockName(String name) { this.lockName = name; }

    public void setBikeID(int id){ this.bikeID = id;}

    public int getLockID() {
        return this.lockID;
    }

    public String getLockName() { return this.lockName; }

    public int getBikeID(){return bikeID;}
}
