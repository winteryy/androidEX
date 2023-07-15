package com.winterry.mysolelife.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.winterry.mysolelife.R
import com.winterry.mysolelife.board.BoardInsideActivity
import com.winterry.mysolelife.board.BoardListLVAdapter
import com.winterry.mysolelife.board.BoardModel
import com.winterry.mysolelife.board.BoardWriteActivity
import com.winterry.mysolelife.databinding.FragmentTalkBinding
import com.winterry.mysolelife.utils.FBAuth
import com.winterry.mysolelife.utils.FBRef

class TalkFragment : Fragment() {

    private lateinit var binding: FragmentTalkBinding

    private val boardDataList = mutableListOf<BoardModel>()

    private val TAG = TalkFragment::class.java.simpleName

    private lateinit var boardLVAdapter : BoardListLVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk, container, false)

        getFBBoardData()

        boardLVAdapter = BoardListLVAdapter(boardDataList)
        binding.boardListView.adapter = boardLVAdapter

        binding.boardListView.setOnItemClickListener { parent, view, position, id ->
        //intent를 통해 액티비티에 직접 데이터 전달
            val intent = Intent(context, BoardInsideActivity::class.java)
            intent.putExtra("title", boardDataList[position].title)
            intent.putExtra("content", boardDataList[position].content)
            intent.putExtra("time", boardDataList[position].time)
            startActivity(intent)

        }

        binding.writeBtn.setOnClickListener {
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }
        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }
        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
        }
        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }

        return binding.root
    }

    private fun getFBBoardData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                boardDataList.clear()

                for (dataModel in dataSnapshot.children) {

                    val item = dataModel.getValue(BoardModel::class.java)
                    boardDataList.add(item!!)
                }

                boardDataList.reverse()

                boardLVAdapter.notifyDataSetChanged()
                Log.d(TAG, boardDataList.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.boardRef.addValueEventListener(postListener)
    }

}