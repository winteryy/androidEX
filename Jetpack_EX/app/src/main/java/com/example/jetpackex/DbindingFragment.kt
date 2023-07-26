package com.example.jetpackex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.jetpackex.databinding.FragmentDbindingBinding

class DbindingFragment : Fragment() {

    lateinit var binding: FragmentDbindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dbinding, container, false)
        binding.fragmentText.text="데이터바인딩 프래그먼트 텍스트"

        return binding.root
    }

}