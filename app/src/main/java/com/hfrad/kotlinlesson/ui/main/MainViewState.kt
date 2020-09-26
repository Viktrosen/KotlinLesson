package com.hfrad.kotlinlesson.ui.main

import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)