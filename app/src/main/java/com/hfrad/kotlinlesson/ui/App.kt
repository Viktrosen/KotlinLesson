package com.hfrad.kotlinlesson.ui

import android.app.Application
import org.koin.android.ext.android.startKoin
import com.hfrad.kotlinlesson.di.appModule
import com.hfrad.kotlinlesson.di.mainModule
import com.hfrad.kotlinlesson.di.noteModule
import com.hfrad.kotlinlesson.di.splashModule

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}

