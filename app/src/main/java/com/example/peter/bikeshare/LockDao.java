package com.example.peter.bikeshare;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
//Interface used to access the "bikes" table.
@Dao
public interface LockDao {

    //Call these methods to perform queries or insert/delete rows
    @Query("SELECT * FROM locks")
    List<Lock> getAll();


    @Query("SELECT COUNT(*) FROM locks")
    int count();

    @Update
    void update(Lock lock);

    @Insert
    void insertAll(Lock... locks);

    @Delete
    void delete(Lock locks);
}
