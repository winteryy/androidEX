package com.example.retrofitex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
        api.getPost1().enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API1", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API1", "fail")
            }
        })

        api.getPostNumber(2).enqueue(object: Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API2", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API2", "fail")
            }
        })
    }
}