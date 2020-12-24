package com.kmk.todoapp;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Todo.class, version = 1,exportSchema = false)
public abstract class TodoDatabase extends RoomDatabase {

    private static TodoDatabase instance;

    public abstract TodoDao todoDao();

    public static synchronized TodoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, TodoDatabase.class, "todo_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}