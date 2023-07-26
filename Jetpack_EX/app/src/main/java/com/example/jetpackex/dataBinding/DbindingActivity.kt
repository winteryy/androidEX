package com.example.jetpackex.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackex.R
import com.example.jetpackex.databinding.ActivityDbindingBinding

class DbindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDbindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dbinding)
        val array:ArrayList<String> = arrayListOf("a", "b", "c", "a", "b", "c", "a", "b", "c", "a", "b",
            "c", "a", "b", "c", "a", "b", "c")

        val dbCustomViewAdapter = DbCustomViewAdapter(array)
        val rv = binding.rv

        rv.adapter = dbCustomViewAdapter
        rv.layoutManager = LinearLayoutManager(this)

    }
}