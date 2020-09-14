package com.hfrad.kotlinlesson.data.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfrad.kotlinlesson.data.NoteRepository
import com.hfrad.kotlinlesson.data.ui.main.MainViewState

class MainViewModel: ViewModel() {
    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        NoteRepository.getNotes().observeForever{
            viewStateLiveData.value = viewStateLiveData.value?.copy(notes = it)?:MainViewState(it)
        }


    }

    fun viewState(): LiveData<MainViewState> = viewStateLiveData

}