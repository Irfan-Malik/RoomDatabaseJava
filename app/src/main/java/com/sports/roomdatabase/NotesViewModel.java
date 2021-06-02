package com.sports.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class NotesViewModel extends AndroidViewModel {
    NoteDao noteDao;
    RoomDatabase roomDatabase;
    LiveData<List<Note>> mAllNotes;

    public NotesViewModel(@NonNull Application application) {
        super(application);

        roomDatabase = RoomDatabase.getRoomDatabase(application);
        noteDao = roomDatabase.getNoteDao();
        mAllNotes = noteDao.getAllNotes();
    }


    LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    public void insert(Note note){
       new InsertAsyncTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteAsyncTask(noteDao).execute(note);
    }


    private class OperationsAsyncTask extends AsyncTask<Note, Void, Void> {

        NoteDao mAsyncTaskDao;

        OperationsAsyncTask(NoteDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }
    }


    private class InsertAsyncTask extends OperationsAsyncTask {

        InsertAsyncTask(NoteDao mNoteDao) {
            super(mNoteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.insert(notes[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends OperationsAsyncTask {

        UpdateAsyncTask(NoteDao noteDao) {
            super(noteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.update(notes[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends OperationsAsyncTask {

        public DeleteAsyncTask(NoteDao noteDao) {
            super(noteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.delete(notes[0]);
            return null;
        }
    }

}
