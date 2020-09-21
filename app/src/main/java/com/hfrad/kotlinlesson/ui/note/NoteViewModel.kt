package com.hfrad.kotlinlesson.ui.note

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.model.NoteResult
import com.hfrad.kotlinlesson.ui.base.BaseViewModel
import ru.geekbrains.gb_kotlin.data.NotesRepository


class NoteViewModel : BaseViewModel<Note?, NoteViewState>() {

    init {
        viewStateLiveData.value = NoteViewState()
    }

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    fun loadNote(noteId: String) {
        NotesRepository.getNoteById(noteId).observeForever { result ->
            result ?: return@observeForever
            when(result){
                is NoteResult.Success<*> ->  viewStateLiveData.value = NoteViewState(note = result.data as? Note)
                is NoteResult.Error -> viewStateLiveData.value = NoteViewState(error = result.error)
            }
        }
    }

    override fun onCleared() {
        pendingNote?.let {
            NotesRepository.saveNote(it)
        }
    }

}