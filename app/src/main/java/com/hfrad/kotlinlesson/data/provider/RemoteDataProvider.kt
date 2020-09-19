package com.hfrad.kotlinlesson.data.provider

import androidx.lifecycle.LiveData
import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.model.NoteResult

interface RemoteDataProvider {
    fun subscribeToAllNotes(): LiveData<NoteResult>
    fun getNoteById(id: String): LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>

}