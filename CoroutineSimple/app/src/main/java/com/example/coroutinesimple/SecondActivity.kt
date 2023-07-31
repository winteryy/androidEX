package com.example.coroutinesimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class SecondActivity : AppCompatActivity() {

    lateinit var viewModel: SecondViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        viewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        viewModel.a()
        viewModel.b()
    }
}