package com.hfrad.kotlinlesson.data

import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.provider.DataProvider


class NotesRepository(val dataProvider: DataProvider) {
    fun getCurrentUser() = dataProvider.getCurrentUser()
    fun getNotes() = dataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = dataProvider.saveNote(note)
    fun getNoteById(id: String) = dataProvider.getNoteById(id)
    fun deleteNote(id: String) = dataProvider.deleteNote(id)
}

