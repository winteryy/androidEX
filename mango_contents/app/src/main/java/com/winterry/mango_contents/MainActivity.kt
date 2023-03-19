package com.winterry.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkBtn = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkBtn.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/O1EySl2Zq7TE",
                "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/33537_1484822170672999.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "제이엘 디저트바"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Tp0aaXWTLtt9",
                "https://mp-seoul-image-production-s3.mangoplate.com/463270/90579_1633541816384_46168?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "핀즈"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/-okgcglXDhXi",
                "https://mp-seoul-image-production-s3.mangoplate.com/569459_1679159640216321.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "앨리스프로젝트"
            )
        )
        items.add(
        ContentsModel(
            "https://www.mangoplate.com/restaurants/G_1KTBxccTBl",
            "https://mp-seoul-image-production-s3.mangoplate.com/503194/1013171_1676559576740_1000009874?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "스테이지바이고디바"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/O1EySl2Zq7TE",
                "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/33537_1484822170672999.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "제이엘 디저트바"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Tp0aaXWTLtt9",
                "https://mp-seoul-image-production-s3.mangoplate.com/463270/90579_1633541816384_46168?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "핀즈"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/-okgcglXDhXi",
                "https://mp-seoul-image-production-s3.mangoplate.com/569459_1679159640216321.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "앨리스프로젝트"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/G_1KTBxccTBl",
                "https://mp-seoul-image-production-s3.mangoplate.com/503194/1013171_1676559576740_1000009874?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "스테이지바이고디바"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerView.adapter = rvAdapter
        rvAdapter.itemClick = object : RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imgUrl", items[position].titleImgUrl)
                startActivity(intent)
            }

        }
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}