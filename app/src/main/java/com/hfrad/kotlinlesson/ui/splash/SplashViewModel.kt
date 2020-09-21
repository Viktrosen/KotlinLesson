package com.hfrad.kotlinlesson.ui.splash

import com.hfrad.kotlinlesson.data.errors.NoAuthException
import com.hfrad.kotlinlesson.ui.base.BaseViewModel
import ru.geekbrains.gb_kotlin.data.NotesRepository

class SplashViewModel(private val repository: NotesRepository = NotesRepository) : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser() {
        repository.getCurrentUser().observeForever {
            viewStateLiveData.value = if (it != null) {
                SplashViewState(isAuth = true)
            } else {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}