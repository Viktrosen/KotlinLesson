package com.hfrad.kotlinlesson.ui.splash

import com.hfrad.kotlinlesson.data.NotesRepository
import com.hfrad.kotlinlesson.data.errors.NoAuthException
import com.hfrad.kotlinlesson.ui.base.BaseViewModel

class SplashViewModel(val notesRepository: NotesRepository) : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser(){
        notesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = if(it != null){
                SplashViewState(authenticated = true)
            } else {
                SplashViewState(error = NoAuthException())
            }
        }
    }

}