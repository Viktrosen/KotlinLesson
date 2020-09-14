package com.hfrad.kotlinlesson.data.ui.note

import androidx.lifecycle.ViewModel
import com.hfrad.kotlinlesson.data.NoteRepository
import com.hfrad.kotlinlesson.data.entity.Note

class NoteViewModel: ViewModel() {

    private var pendingNote: Note?=null

    fun save(note:Note){
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let {
            NoteRepository.saveNote(it)
        }
    }
}