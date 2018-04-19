package com.example.peter.bikeshare;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
//Interface used to access the "bikes" table.
@Dao
public interface BikeDao {

    //Call these methods to perform quereies or insert/delete rows
    @Query("SELECT * FROM bikes")
    List<Bike> getAll();

    @Query("SELECT bike_id, lat, lon FROM bikes")
    List<idLocation> getLocations();

    @Query("Select * FROM bikes WHERE bike_id = :id")
    Bike findByID(int id);

    @Query("SELECT COUNT(*) FROM bikes")
    int count();

    @Insert
    void insertAll(Bike... bikes);

    @Delete
    void delete(Bike bikes);
}
