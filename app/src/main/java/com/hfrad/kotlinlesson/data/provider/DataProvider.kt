package com.hfrad.kotlinlesson.data.provider

import androidx.lifecycle.LiveData
import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.entity.User
import com.hfrad.kotlinlesson.data.model.NoteResult

interface DataProvider {
    fun getCurrentUser() : LiveData<User?>
    fun subscribeToAllNotes() : LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
    fun getNoteById(id: String) : LiveData<NoteResult>
    fun deleteNote(id: String) : LiveData<NoteResult>
}