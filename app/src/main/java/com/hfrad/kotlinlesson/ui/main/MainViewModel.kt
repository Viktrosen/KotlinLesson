package com.hfrad.kotlinlesson.ui.main

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import com.hfrad.kotlinlesson.data.NotesRepository
import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.data.model.NoteResult
import com.hfrad.kotlinlesson.ui.base.BaseViewModel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class MainViewModel(notesRepository: NotesRepository) : BaseViewModel<List<Note>?>() {
    private val notesChannel = notesRepository.getNotes()

    init {
        launch {
            notesChannel.consumeEach {
                when (it) {
                    is NoteResult.Success<*> -> setData(it.data as? List<Note>)
                    is NoteResult.Error -> setError(it.error)
                }
            }
        }
    }

    @VisibleForTesting
    public override fun onCleared() {
        super.onCleared()
        notesChannel.cancel()
    }
}