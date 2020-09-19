package ru.geekbrains.gb_kotlin.data


import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.provider.FireStoreProvider
import com.hfrad.kotlinlesson.data.provider.RemoteDataProvider


object NotesRepository {

    private val remoteProvider: RemoteDataProvider = FireStoreProvider()

    fun getNotes() = remoteProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = remoteProvider.saveNote(note)
    fun getNoteById(id: String) = remoteProvider.getNoteById(id)

}