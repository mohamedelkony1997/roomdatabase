package com.example.elkony.roomdatabase.DATABASE;

import android.content.Context;

import com.example.elkony.roomdatabase.DATABASE.Daos.NotesDaos;
import com.example.elkony.roomdatabase.DATABASE.Models.Notes;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Notes.class},version = 1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    private static MyDataBase dataBase;
   private    static final String DB_name="NotesDataBase";
   public abstract NotesDaos notesDaos();
    public MyDataBase() {
    }
    public static MyDataBase getInstance(Context context){
        if(dataBase==null){
dataBase= Room.databaseBuilder(context,MyDataBase.class,DB_name).
        fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
return dataBase;
    }
}
