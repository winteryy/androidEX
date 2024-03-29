package com.example.workmanagerchaining

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManagerC(context: Context, workerParameters: WorkerParameters): Worker(context, workerParameters) {

    override fun doWork(): Result {

        for(i in 1..3){

            Thread.sleep(1000)
            Log.d("WorkManagerC", i.toString())

        }

        return Result.success()
    }


}