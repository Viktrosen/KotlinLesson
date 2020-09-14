package com.hfrad.kotlinlesson.data.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hfrad.kotlinlesson.R
import com.hfrad.kotlinlesson.data.entity.Note

class MainAdapter (var onItemClick:((Note)->Unit)?=null ): RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }


inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title = itemView.findViewById<TextView>(R.id.title)
    private val body = itemView.findViewById<TextView>(R.id.body)

    fun bind(note: Note) = with(itemView as CardView) {
        title.text = note.title
        body.text = note.note


        val color = when (note.color) {
            Note.Color.WHITE -> R.color.white
            Note.Color.VIOLET -> R.color.violet
            Note.Color.RED -> R.color.red
            Note.Color.YELLOW -> R.color.yellow
            Note.Color.PINK -> R.color.pink
            Note.Color.GREEN -> R.color.green
        }

        setCardBackgroundColor(ContextCompat.getColor(itemView.context, color))


        itemView.setOnClickListener {
            onItemClick?.invoke(note)
        }
    }

}
}