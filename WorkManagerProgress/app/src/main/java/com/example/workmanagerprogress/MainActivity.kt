package com.example.workmanagerprogress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.workmanagerprogress.WorkManagerTest.Companion.HowMuch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManagerTest = OneTimeWorkRequestBuilder<WorkManagerTest>().build()

        WorkManager.getInstance(this).enqueue(workManagerTest)

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workManagerTest.id)
            .observe(this, Observer {
                val progress = it.progress
                val value = progress.getInt(HowMuch, 0)
                if(value != 0){
                    Log.d("MainActivity", value.toString())
                }
                if(value == 100){
                    Log.d("MainActivity", "finished")
                }
            })

    }
}