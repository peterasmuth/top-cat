package com.example.peter.bikeshare;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    public int user_id;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "MI")
    public String MI;

    @ColumnInfo(name = "email")
    public String email;

    public User (String fn, String ln, String mi, String em){
        firstName = fn;
        lastName = ln;
        MI = mi;
        email = em;
    }
}
