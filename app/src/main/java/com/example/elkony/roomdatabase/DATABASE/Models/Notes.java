package com.example.elkony.roomdatabase.DATABASE.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Notes {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String title;
    @ColumnInfo
    String content;
    @ColumnInfo
    String datatime;

    public Notes() {
    }

    public Notes(String title, String content, String datatime) {
        this.title = title;
        this.content = content;
        this.datatime = datatime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }
}
