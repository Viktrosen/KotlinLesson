package com.hfrad.kotlinlesson

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainViewModel: ViewModel() {
    private val viewStateLiveData = MutableLiveData<String>()
    private var model:Model  = Model()

    init {


        viewStateLiveData.value = "Hello "+ model.getModelState()
        model.setModelState(model.getModelState())

    }

    fun getViewState():LiveData<String> = viewStateLiveData


}