package com.hfrad.kotlinlesson.data.provider

import androidx.lifecycle.LiveData
import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.entity.User
import com.hfrad.kotlinlesson.data.model.NoteResult
import kotlinx.coroutines.channels.ReceiveChannel

interface DataProvider {
    fun subscribeToAllNotes() : ReceiveChannel<NoteResult>

    suspend fun getCurrentUser() : User?
    suspend fun saveNote(note: Note) : Note
    suspend fun getNoteById(id: String) : Note?
    suspend fun deleteNote(id: String)
}