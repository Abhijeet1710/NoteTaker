package com.abhijeet.notetake.model

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getAllNotes() : LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note : Note)

}