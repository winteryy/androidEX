package com.example.jetpacklivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacklivedata.databinding.ActivityLiveTransBinding
import kotlin.math.pow

class LiveTransActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveTransBinding
    private lateinit var viewModel: LiveViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_trans)
        viewModel = ViewModelProvider(this)[LiveViewModel::class.java]

        binding.btnArea.setOnClickListener {
            val num = binding.inputArea.text.toString().toInt()

            viewModel.setLiveDataValue(num)
        }

//        viewModel.liveCount.observe(this, Observer {
//            binding.resultArea1.text = it.times(2).toString()
//            binding.resultArea2.text = it.times(it).toString()
//        })

        viewModel.mapData.observe(this, Observer {
            binding.resultArea1.text = it.toString()
        })

        viewModel.switchMapLiveData.observe(this, Observer {
            binding.resultArea2.text = it.toString()
        })
    }
}