package com.hfrad.kotlinlesson.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hfrad.kotlinlesson.data.entity.Note
import java.util.*


object NoteRepository {

    private val notesLiveData = MutableLiveData<List<Note>>()

    private val notes = mutableListOf(
            Note(     UUID.randomUUID().toString(),
                    "Моя первая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    Note.Color.WHITE),
            Note(UUID.randomUUID().toString(),"Моя вторая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    Note.Color.VIOLET),
            Note(UUID.randomUUID().toString(),"Моя третья заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    Note.Color.YELLOW),
            Note(UUID.randomUUID().toString(),"Моя четвёртая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    Note.Color.RED),
            Note(UUID.randomUUID().toString(),"Моя пятая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    Note.Color.PINK),
            Note(UUID.randomUUID().toString(),"Моя шестая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    Note.Color.GREEN)
    )

    init {
        notesLiveData.value = notes
    }

    fun getNotes(): LiveData<List<Note>> {
        return notesLiveData
    }

    fun saveNote(note:Note){
        addOrReplace(note)
    }

    fun addOrReplace(note:Note){
        for(i in 0 until notes.size){
            if (notes[i]==note){
                notes[i]=note
                return
            }
        }
    }

}