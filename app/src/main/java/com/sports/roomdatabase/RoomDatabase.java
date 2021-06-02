package com.sports.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

@Database(entities = Note.class, version = 1)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    public abstract  NoteDao getNoteDao();

    private static volatile RoomDatabase roomDatabase;

    static RoomDatabase getRoomDatabase(Context context){
        if(roomDatabase == null){
            synchronized (RoomDatabase.class){
                if(roomDatabase == null){
                    roomDatabase = Room.databaseBuilder(context.getApplicationContext(),RoomDatabase.class,"database").build();
                }
            }
        }
        return roomDatabase;
    }
}
