package com.example.retrofitcoroutineglide.api

import com.example.retrofitcoroutineglide.model.Plant
import retrofit2.http.GET

interface MyApi {

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlant(): List<Plant>

}