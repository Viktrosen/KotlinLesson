package com.hfrad.kotlinlesson.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import com.hfrad.kotlinlesson.data.NotesRepository
import com.hfrad.kotlinlesson.data.provider.DataProvider
import com.hfrad.kotlinlesson.data.provider.FirestoreProvider
import com.hfrad.kotlinlesson.ui.main.MainViewModel
import com.hfrad.kotlinlesson.ui.note.NoteViewModel
import com.hfrad.kotlinlesson.ui.splash.SplashViewModel

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single<DataProvider> { FirestoreProvider(get(), get()) }
    single { NotesRepository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}