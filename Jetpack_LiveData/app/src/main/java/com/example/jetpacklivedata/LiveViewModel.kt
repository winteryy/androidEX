package com.example.jetpacklivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class LiveViewModel: ViewModel() {

    private var _mutableCount = MutableLiveData(0)
    val liveCount: LiveData<Int>
        get() = _mutableCount

    val mapData = Transformations.map(liveCount){
        it+it
    }

    val switchMapLiveData = Transformations.switchMap(liveCount){
        changeValue(it)
    }


    fun setLiveDataValue(count: Int){
        _mutableCount.value = count
    }

    fun changeValue(count: Int): MutableLiveData<Int> {
        val testLiveData = MutableLiveData(count*count)
        return testLiveData
    }
}