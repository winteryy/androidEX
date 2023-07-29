package com.example.jetpacklivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacklivedata.databinding.ActivityIntegratedBinding

class IntegratedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntegratedBinding
    private lateinit var viewModel: NewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_integrated)
        viewModel = ViewModelProvider(this)[NewViewModel::class.java]
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.nextBtn.setOnClickListener {
            viewModel.getNextData()
        }
    }
}