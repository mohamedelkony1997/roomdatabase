package com.example.elkony.roomdatabase.DATABASE.Daos;

import android.provider.ContactsContract;

import com.example.elkony.roomdatabase.DATABASE.Models.Notes;

import java.util.List;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

public interface NotesDaos {
    @Insert
    void addnote(ContactsContract.CommonDataKinds.Note note);

    @Delete
    void deletenote(ContactsContract.CommonDataKinds.Note note);

    @Query("delete from Notes where id=:id")
    void deletefromnote(int id);

    @Query("select * from Notes where title =:title  ")
   List <ContactsContract.CommonDataKinds.Note> searchbytitle(String title);
    @Query("select *from Notes")
    List<ContactsContract.CommonDataKinds.Note> getallnotes();
    @Update
    void updatenode(ContactsContract.CommonDataKinds.Note note);
}
