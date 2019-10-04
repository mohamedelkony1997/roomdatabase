package com.example.elkony.roomdatabase.DATABASE.Daos;

import android.provider.ContactsContract;

import com.example.elkony.roomdatabase.DATABASE.Models.Notes;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface NotesDaos {
    @Insert
    void addnote(Notes note);

    @Delete
    void deletenote(Notes notes);

    @Query("delete from Notes where id=:id")
    void deletefromnote(int id);

    @Query("select * from Notes where title =:title  ")
   List <Notes> searchbytitle(String title);
    @Query("select *from Notes")
    List<Notes> getallnotes();
    @Update
    void updatenode(Notes notes);
}
