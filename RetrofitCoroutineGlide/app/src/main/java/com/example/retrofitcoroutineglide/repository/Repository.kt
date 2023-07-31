package com.example.retrofitcoroutineglide.repository

import com.example.retrofitcoroutineglide.api.MyApi
import com.example.retrofitcoroutineglide.api.RetrofitInstance
import retrofit2.create

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllPlant()

}