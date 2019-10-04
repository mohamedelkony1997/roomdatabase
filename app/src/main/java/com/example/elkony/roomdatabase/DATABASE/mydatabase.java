package com.example.elkony.roomdatabase.DATABASE;

import android.content.Context;

import com.example.elkony.roomdatabase.DATABASE.Daos.NotesDaos;
import com.example.elkony.roomdatabase.DATABASE.Models.Notes;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Notes.class},version = 1)
public abstract class mydatabase extends RoomDatabase {
    private static mydatabase database;
    private static final String Db_NAME="NotesDatabase";
    public abstract NotesDaos notesDaos();
    private mydatabase() {
    }
    public static  mydatabase getinstance(Context context){
       if(database==null){
     database= Room.databaseBuilder(context,mydatabase.class,Db_NAME)
             .fallbackToDestructiveMigration()
             .allowMainThreadQueries()
             .build();

    }
  return database;
    }

}
