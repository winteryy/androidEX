package com.example.jetpackex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val array:ArrayList<String> = arrayListOf("a", "b", "c", "a", "b", "c", "a", "b", "c", "a", "b",
            "c", "a", "b", "c", "a", "b", "c")

        val customAdapter = CustomAdapter(array)
        val rv : RecyclerView = findViewById(R.id.rv)
        rv.adapter = customAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}