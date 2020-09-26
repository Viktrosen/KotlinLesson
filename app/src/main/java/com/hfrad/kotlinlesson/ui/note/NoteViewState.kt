package com.hfrad.kotlinlesson.ui.note

import com.hfrad.kotlinlesson.data.entity.Note
import com.hfrad.kotlinlesson.ui.base.BaseViewState

class NoteViewState(data: Data = Data(), error: Throwable? = null) : BaseViewState<NoteViewState.Data>(data, error) {
    data class Data(val isDeleted: Boolean = false, val note: Note? = null)
}