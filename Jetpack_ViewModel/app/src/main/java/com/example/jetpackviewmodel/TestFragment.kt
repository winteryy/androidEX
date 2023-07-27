package com.example.jetpackviewmodel

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackviewmodel.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private val TAG = TestFragment::class.java.simpleName

    private lateinit var binding: FragmentTestBinding

    private val viewModel: TestFragmentViewModel by activityViewModels()

//    var countValue = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d(TAG, "onAttach log")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_test, container, false)

        Log.d(TAG, "onCreateView log")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        binding.fragmentText.text = viewModel.getCount().toString()


//        viewModel = ViewModelProvider(this).get(TestFragmentViewModel::class.java)
//
//        binding.resultArea.text = viewModel.getCount().toString()
//
//        binding.plus.setOnClickListener {
//            countValue++
//            binding.resultArea.text = countValue.toString()
//            viewModel.plus()
//            binding.resultArea.text= viewModel.getCount().toString()
//        }

//        binding.minus.setOnClickListener {
//            countValue--
//            binding.resultArea.text = countValue.toString()
//            viewModel.minus()
//            binding.resultArea.text= viewModel.getCount().toString()
//        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume log")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop log")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView log")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy log")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach log")
    }

}