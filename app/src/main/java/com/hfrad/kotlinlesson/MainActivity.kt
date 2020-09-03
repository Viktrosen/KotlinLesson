package com.hfrad.kotlinlesson

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button:Button = findViewById(R.id.button1)
        button.setOnClickListener {
            viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
            viewModel.getViewState().observe(this, Observer {value->
                Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
            })
        }


    }



}

