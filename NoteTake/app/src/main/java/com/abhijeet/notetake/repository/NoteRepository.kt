package com.abhijeet.notetake.repository

import androidx.lifecycle.LiveData
import com.abhijeet.notetake.model.Note
import com.abhijeet.notetake.model.NoteDao

class NoteRepository(private val noteDao : NoteDao ) {

    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note : Note) {
        noteDao.insert(note)
    }

    suspend fun delete(note : Note) {
        noteDao.delete(note)
    }

}