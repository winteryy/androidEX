package com.example.jetpackex.dataBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackex.R
import com.example.jetpackex.databinding.TextRowItemBinding

class DbCustomViewAdapter(val dataSet: ArrayList<String>) : RecyclerView.Adapter<DbCustomViewAdapter.ViewHolder>() {

    class ViewHolder(binding: TextRowItemBinding): RecyclerView.ViewHolder(binding.root){

        val myText: TextView = binding.myText
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DbCustomViewAdapter.ViewHolder {
        val view = DataBindingUtil.inflate<TextRowItemBinding>(LayoutInflater.from(parent.context),
        R.layout.text_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DbCustomViewAdapter.ViewHolder, position: Int) {
        holder.myText.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}