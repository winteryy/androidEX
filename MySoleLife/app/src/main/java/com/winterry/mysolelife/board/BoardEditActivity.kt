package com.winterry.mysolelife.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.winterry.mysolelife.R
import com.winterry.mysolelife.databinding.ActivityBoardEditBinding
import com.winterry.mysolelife.utils.FBRef

class BoardEditActivity : AppCompatActivity() {

    private val TAG = BoardEditActivity::class.java.simpleName

    private lateinit var  binding : ActivityBoardEditBinding
    private lateinit var key : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_edit)

        key = intent.getStringExtra("key").toString()
        getBoardData(key)
        getImageData(key)
    }

    private fun getImageData(key: String){
        val storageReference = Firebase.storage.reference.child(key)

        // ImageView in your Activity
        val imageViewFromFB = binding.imageArea

        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener {
            if(it.isSuccessful){
                Glide.with(this)
                    .load(it.result)
                    .into(imageViewFromFB)
            }else{

            }
        })
    }
    private fun getBoardData(key: String){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                try{
                    val dataModel = dataSnapshot.getValue(BoardModel::class.java)
                    binding.titleArea.setText(dataModel?.title)
                    binding.contentArea.setText(dataModel?.content)
                }catch (e: Exception){
                    Log.d(TAG, "삭제완료")
                }


            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.boardRef.child(key).addValueEventListener(postListener)
    }
}