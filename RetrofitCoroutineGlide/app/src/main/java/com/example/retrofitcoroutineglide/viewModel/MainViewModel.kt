package com.example.retrofitcoroutineglide.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcoroutineglide.api.MyApi
import com.example.retrofitcoroutineglide.api.RetrofitInstance
import com.example.retrofitcoroutineglide.model.Plant
import com.example.retrofitcoroutineglide.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    //val retrofitInstance: MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val repository = Repository()

    private val _result = MutableLiveData<List<Plant>>()
    val result: LiveData<List<Plant>>
        get() = _result

    fun getAllData() = viewModelScope.launch {

        Log.d("MainViewModel", repository.getAllData().toString() )
        _result.value = repository.getAllData()

    }
}