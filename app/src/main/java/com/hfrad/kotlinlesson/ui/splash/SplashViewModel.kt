package com.hfrad.kotlinlesson.ui.splash

import com.hfrad.kotlinlesson.data.NotesRepository
import com.hfrad.kotlinlesson.data.errors.NoAuthException
import com.hfrad.kotlinlesson.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class SplashViewModel(val notesRepository: NotesRepository) : BaseViewModel<Boolean?>() {

    fun requestUser() = launch {
        notesRepository.getCurrentUser()?.let {
            setData(true)
        } ?: setError(NoAuthException())
    }

}