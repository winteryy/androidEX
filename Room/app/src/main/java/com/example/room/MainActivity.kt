package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.adapter.CustomAdapter
import com.example.room.db.TextDatabase
import com.example.room.entity.TextEntity
import com.example.room.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val inputArea: EditText = findViewById(R.id.textInputArea)
        val insertBtn: Button = findViewById(R.id.insertBtn)
        val getAllBtn: Button = findViewById(R.id.getDataBtn)
        val deleteBtn: Button = findViewById(R.id.deleteBtn)
        val rv: RecyclerView = findViewById(R.id.rv)

        viewModel.textList.observe(this, Observer {
            val customAdapter = CustomAdapter(it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })

        insertBtn.setOnClickListener {
            viewModel.insertData(inputArea.text.toString())
            inputArea.setText("")
        }

        getAllBtn.setOnClickListener {
            viewModel.getData()

        }

        deleteBtn.setOnClickListener {
            viewModel.deleteData()
        }

    }
}