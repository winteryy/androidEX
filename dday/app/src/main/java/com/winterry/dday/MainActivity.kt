package com.winterry.dday

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val endBtn = findViewById<Button>(R.id.endBtn)

        val calenderStart = Calendar.getInstance()
        val calenderEnd = Calendar.getInstance()


        startBtn.setOnClickListener {

            val today = GregorianCalendar()
            val tYear = today.get(Calendar.YEAR)
            val tMonth = today.get(Calendar.MONTH)
            val tDay = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    calenderStart.set(year, month+1, dayOfMonth)

                    Log.d("date", calenderStart.toString())
                }

            }, tYear, tMonth, tDay)
            dlg.show()
        }

        endBtn.setOnClickListener {
            val today = GregorianCalendar()
            val tYear = today.get(Calendar.YEAR)
            val tMonth = today.get(Calendar.MONTH)
            val tDay = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    calenderEnd.set(year, month+1, dayOfMonth)

                    val finalDate = TimeUnit.MILLISECONDS.toDays(calenderEnd.timeInMillis - calenderStart.timeInMillis)

                    val textArea = findViewById<TextView>(R.id.finalDate)
                    Log.d("date", finalDate.toString())
                    textArea.setText(finalDate.toString())
                }

            }, tYear, tMonth, tDay)
            dlg.show()
        }
    }
}