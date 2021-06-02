package com.sports.roomdatabase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    LiveData<List<Note>> getAllNotes();

    @Insert
    void insert(Note note);

    @Query("SELECT * FROM note WHERE id=:noteId")
    LiveData<Note> getNote(String noteId);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);
}
