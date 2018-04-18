package com.example.peter.bikeshare;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BikeDao {
    @Query("SELECT * FROM bikes")
    List<Bike> getAll();

    @Query("SELECT bike_id, lat, lon FROM bikes")
    List<idLocation> getLocations();

    @Query("SELECT COUNT(*) FROM bikes")
    int count();

    @Insert
    void insertAll(Bike... bikes);

    @Delete
    void delete(Bike bikes);
}
