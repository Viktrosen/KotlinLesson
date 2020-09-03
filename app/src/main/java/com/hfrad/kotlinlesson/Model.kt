package com.hfrad.kotlinlesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Model(){
    private var count = 0
    init {
        count
    }

    fun getModelState(): Int = count
    fun setModelState(count:Int){
        this.count=count
    }

}