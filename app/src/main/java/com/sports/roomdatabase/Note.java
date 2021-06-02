package com.sports.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
public class Note {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "notes")
    private String mNote;

    public Note(String id, String note){
        this.id = id;
        this.mNote = note;
    }

    public String getId(){
        return id;
    }

    @NonNull
    public String getNote() {
        return mNote;
    }
}
