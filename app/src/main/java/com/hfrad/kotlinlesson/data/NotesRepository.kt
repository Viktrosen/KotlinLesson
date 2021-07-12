package com.hfrad.kotlinlesson.data

import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.provider.DataProvider


class NotesRepository(val dataProvider: DataProvider) {
    fun getNotes() = dataProvider.subscribeToAllNotes()
    suspend fun getCurrentUser() = dataProvider.getCurrentUser()
    suspend fun saveNote(note: Note) = dataProvider.saveNote(note)
    suspend fun getNoteById(id: String) = dataProvider.getNoteById(id)
    suspend fun deleteNote(id: String) = dataProvider.deleteNote(id)
}

