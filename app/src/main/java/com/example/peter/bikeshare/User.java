package com.example.peter.bikeshare;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")
public class User {


    @PrimaryKey
    private int user_id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "MI")
    private String MI;

    @ColumnInfo(name = "email")
    private String email;

    public User (){

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setMI(String MI) {
        this.MI = MI;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getMI() {
        return MI;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getUser_id() {
        return user_id;
    }
}

