package com.winterry.mysolelife.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FBRef {

    companion object{
        val database = Firebase.database

        val bookmarkRef = database.getReference("bookmark_list")
        val boardRef = database.getReference("board")
        val commentRef = database.getReference("comment")

        val category1 = database.getReference("contents")
        val category2 = database.getReference("contents2")

    }
}