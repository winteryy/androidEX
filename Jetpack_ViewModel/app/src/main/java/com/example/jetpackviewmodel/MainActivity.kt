package com.example.jetpackviewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

//    private var countValue = 0

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val plusBtn: Button = findViewById(R.id.plus)
        val minusBtn: Button = findViewById(R.id.minus)

        val resultArea: TextView = findViewById(R.id.result)

        resultArea.text = viewModel.getCount().toString()

        val fragBtn: Button = findViewById(R.id.fragBtn)

        fragBtn.setOnClickListener {
            val intent = Intent(this, FragActivity::class.java)
            startActivity(intent)
        }

        plusBtn.setOnClickListener {
            viewModel.plus()
            resultArea.text = viewModel.getCount().toString()
//            countValue++
//            resultArea.text = countValue.toString()
        }

        minusBtn.setOnClickListener {
            viewModel.minus()
            resultArea.text = viewModel.getCount().toString()
//            countValue--
//            resultArea.text = countValue.toString()
        }

        Log.d(TAG, "onCreate log")
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart log")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume log")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause log")
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop log")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy log")
    }

}