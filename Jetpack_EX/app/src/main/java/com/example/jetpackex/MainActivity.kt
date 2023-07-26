package com.example.jetpackex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.jetpackex.dataBinding.DbindingActivity
import com.example.jetpackex.databinding.ActivityMainBinding
import com.example.jetpackex.viewBinding.VbindingActivity

class MainActivity : AppCompatActivity() {

    //    2. viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        1. without binding
//        setContentView(R.layout.activity_main)

//        2. viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btn1.text = "abcd"
        binding.btn1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btn2.setOnClickListener {
            val intent = Intent(this, DatabindingActivity::class.java)
            startActivity(intent)
        }

        binding.btn3.setOnClickListener {
            val intent = Intent(this, VbindingActivity::class.java)
            startActivity(intent)
        }

        binding.btn4.setOnClickListener {
            val intent = Intent(this, DbindingActivity::class.java)
            startActivity(intent)
        }

//        1-1. findViewById
//        val btn1 : Button = findViewById(R.id.btn1)
//        btn1.text = "abcd"

//        1-2. Kotlin Extensions(deprecated)
//        btn1.text = "abcd"


    }

}