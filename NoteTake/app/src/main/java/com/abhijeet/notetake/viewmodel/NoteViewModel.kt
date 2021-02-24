package com.abhijeet.notetake.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.abhijeet.notetake.model.Note
import com.abhijeet.notetake.model.NoteDatabase
import com.abhijeet.notetake.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel (application : Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<Note>>
    private val repository : NoteRepository

    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(note : Note) = viewModelScope.launch (Dispatchers.IO){
        repository.delete(note)
    }

    fun insertNote(note : Note) = viewModelScope.launch (Dispatchers.IO){
        repository.insert(note)
    }

}