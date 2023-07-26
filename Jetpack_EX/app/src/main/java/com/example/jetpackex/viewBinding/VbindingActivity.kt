package com.example.jetpackex.viewBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackex.R
import com.example.jetpackex.databinding.ActivityVbindingBinding

class VbindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVbindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVbindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val array:ArrayList<String> = arrayListOf("a", "b", "c", "a", "b", "c", "a", "b", "c", "a", "b",
            "c", "a", "b", "c", "a", "b", "c")

        val customViewAdapter = CustomViewAdapter(array)
        val rv = binding.rv
        rv.adapter = customViewAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}