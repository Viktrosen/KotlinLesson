package com.hfrad.kotlinlesson.data

import com.hfrad.kotlinlesson.data.entity.Note

object NoteRepository {
    private val notes: List<Note> = listOf(
            Note("Моя первая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    0xfff06292.toInt()),
            Note("Моя вторая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    0xff9575cd.toInt()),
            Note("Моя третья заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    0xff64b5f6.toInt()),
            Note("Моя четвёртая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    0xff4db6ac.toInt()),
            Note("Моя пятая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    0xffb2ff59.toInt()),
            Note("Моя шестая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    0xffffeb3b.toInt()),
            Note("Моя седьмая заметка",
                    "Kotlin очень краткий, но при этом выразительный язык",
                    0xffff6e40.toInt())
    )

    fun getNotes(): List<Note> {
        return notes
    }

}