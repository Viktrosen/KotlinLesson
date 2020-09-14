package com.hfrad.kotlinlesson.data.ui.note

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.hfrad.kotlinlesson.R
import com.hfrad.kotlinlesson.data.entity.Note
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.item_note.*
import java.text.SimpleDateFormat
import java.util.*

class NoteActivity: AppCompatActivity() {
    companion object{
        private const val NOTE_KEY ="note"
        private const val DATE_FORMAT = "dd.MM.yy HH:mm"


        fun start(context:Context,note: Note?=null) = Intent(context,NoteActivity::class.java).apply {
            putExtra(NOTE_KEY,note)
            context.startActivity(this)
        }
    }

    private var note:Note ?=null
    lateinit var viewModel:NoteViewModel

    val textWatcher = object:TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            saveNote()
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun afterTextChanged(p0: Editable?) {}

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        note = intent.getParcelableExtra(NOTE_KEY)
        //setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        supportActionBar?.title = note?.let {
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(it.lastChanged)
        }?: getString(R.string.new_note)
        initView()
    }

    private fun initView(){
        note?.let {
           titleEt.setText(it.title)
           bodyEt.setText(it.note)

            val color = when(it.color){
                Note.Color.WHITE -> R.color.white
                Note.Color.VIOLET ->R.color.violet
                Note.Color.RED ->R.color.red
                Note.Color.YELLOW ->R.color.yellow
                Note.Color.PINK ->R.color.pink
                Note.Color.GREEN ->R.color.green
            }

            toolbar.setBackgroundColor(ResourcesCompat.getColor(resources,color,null))
        }

        titleEt.addTextChangedListener(textWatcher)
        bodyEt.addTextChangedListener(textWatcher)
    }

    fun saveNote(){
        titleEt.text?.let {
            if (it.length<3) return
        }?:return


        note = note?.copy(
        title = titleEt.text.toString(),
        note = bodyEt.text.toString(),
        lastChanged = Date()) ?: Note(UUID.randomUUID().toString(), title = titleEt.text.toString(),note = bodyEt.text.toString())

        note?.let { viewModel.save(it) }
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when(item?.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}