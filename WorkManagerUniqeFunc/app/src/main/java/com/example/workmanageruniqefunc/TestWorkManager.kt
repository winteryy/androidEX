package com.example.workmanageruniqefunc

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class TestWorkManager(context: Context, params: WorkerParameters): CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {

        Log.d("TestWorkManager", "START")

        for(i in 0..3){
            Log.d("TestWorkManager", i.toString())
            delay(1000)
        }


        Log.d("TestWorkManager", "END")
        return Result.success()
    }

}