package com.hfrad.kotlinlesson.ui.note

import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.ui.base.BaseViewState

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)