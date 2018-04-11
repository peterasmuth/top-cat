package com.example.peter.bikeshare;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.content.Context;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static final String DB_NAME = "UserDatabase.db";
    private static volatile AppDatabase instance;

    static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context){
        return Room.databaseBuilder(context,AppDatabase.class,DB_NAME).build();
    }

    public abstract UserDao userDao();
}