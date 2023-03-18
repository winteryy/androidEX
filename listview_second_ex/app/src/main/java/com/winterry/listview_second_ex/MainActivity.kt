package com.winterry.listview_second_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val listItem = mutableListOf("A", "B", "C")

        val listItem2 = mutableListOf<ListViewModel>()
        listItem2.add(ListViewModel("A", "B"))
        listItem2.add(ListViewModel("C", "D"))
        listItem2.add(ListViewModel("E", "F"))

        val listView = findViewById<ListView>(R.id.mainListView)

        val listViewAdapter = ListViewAdapter(listItem2)
        listView.adapter = listViewAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, listItem2[position].text2, Toast.LENGTH_SHORT).show()
        }

    }
}