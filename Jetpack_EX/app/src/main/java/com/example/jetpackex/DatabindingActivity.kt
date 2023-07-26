package com.example.jetpackex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.jetpackex.databinding.ActivityDatabindingBinding

class DatabindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatabindingBinding

    var testCount = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)


//        binding.textArea.text = "바뀐 텍스트"

        val person = Person("김이름", 20)
        binding.user = person


        binding.textArea.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    fun myClick(view: View){
        Log.d("DatabindingActivity", "onClick")
        testCount++

        val person = Person("김이름", testCount)
        binding.user = person
    }
}