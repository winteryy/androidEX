package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var db: SQLiteHelperSample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = SQLiteHelperSample(this)

        val inputArea: EditText = findViewById(R.id.inputArea)
        val resultArea: TextView = findViewById(R.id.resultArea)

        val insertBtn: Button = findViewById(R.id.insertBtn)
        val getAllBtn: Button = findViewById(R.id.getAllBtn)
        val deleteAllBtn: Button = findViewById(R.id.deleteAllBtn)

        insertBtn.setOnClickListener {
            val inputText = inputArea.text.toString()
            db.insert(inputText)
            inputArea.setText("")
        }

        getAllBtn.setOnClickListener {
            val arr = db.getAllData()

            resultArea.text = arr.toString()
        }

        deleteAllBtn.setOnClickListener {
            db.deleteAll()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}