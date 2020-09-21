package com.hfrad.kotlinlesson.data.provider

import androidx.lifecycle.LiveData
import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.model.NoteResult
import com.hfrad.kotlinlesson.data.model.User

interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
    fun getCurrentUser(): LiveData<User?>

}