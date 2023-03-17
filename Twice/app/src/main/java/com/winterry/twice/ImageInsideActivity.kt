package com.winterry.twice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ImageInsideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val getData = intent.getStringExtra("data")
        val memberImg = findViewById<ImageView>(R.id.memberImageArea)
        //Toast.makeText(this, getData, Toast.LENGTH_LONG).show()
        if(getData=="1"){
            memberImg.setImageResource(R.drawable.member_1)
        }else if(getData=="2"){
            memberImg.setImageResource(R.drawable.member_2)
        }else if(getData=="3"){
            memberImg.setImageResource(R.drawable.member_3)
        }else if(getData=="4"){
            memberImg.setImageResource(R.drawable.member_4)
        }else if(getData=="5"){
            memberImg.setImageResource(R.drawable.member_5)
        }else if(getData=="6"){
            memberImg.setImageResource(R.drawable.member_6)
        }else if(getData=="7"){
            memberImg.setImageResource(R.drawable.member_7)
        }else if(getData=="8") {
            memberImg.setImageResource(R.drawable.member_8)
        }else if(getData=="9"){
            memberImg.setImageResource(R.drawable.member_9)
        }
    }
}