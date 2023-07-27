package com.example.jetpackviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackviewmodel.databinding.ActivityFragBinding

class FragActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragBinding
    lateinit var viewModel: TestFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if(savedInstanceState == null){
//
//            val transaction = manager.beginTransaction()
//            val fragment = TestFragment()
//            transaction.replace(R.id.frameArea, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//
//        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_frag)
        viewModel = ViewModelProvider(this).get(TestFragmentViewModel::class.java)

        binding.resultArea.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener {
//            countValue++
//            binding.resultArea.text = countValue.toString()
            viewModel.plus()
            binding.resultArea.text= viewModel.getCount().toString()
        }

        binding.minus.setOnClickListener {
//            countValue--
//            binding.resultArea.text = countValue.toString()
            viewModel.minus()
            binding.resultArea.text= viewModel.getCount().toString()
        }

        val manager = supportFragmentManager

        binding.fragBtn.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = TestFragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}