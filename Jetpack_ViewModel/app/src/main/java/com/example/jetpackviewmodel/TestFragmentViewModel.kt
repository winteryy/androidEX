package com.example.jetpackviewmodel

import androidx.lifecycle.ViewModel

class TestFragmentViewModel: ViewModel() {

    var countValue = 0

    fun plus(){
        countValue++
    }

    fun minus(){
        countValue--
    }

    fun getCount(): Int{
        return countValue
    }
}