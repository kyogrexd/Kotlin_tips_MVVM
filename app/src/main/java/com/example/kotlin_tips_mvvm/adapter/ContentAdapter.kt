package com.example.kotlin_tips_mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_tips_mvvm.data.Content
import com.example.kotlin_tips_mvvm.databinding.ItemContentBinding
import com.example.kotlin_tips_mvvm.helper.format
import com.example.kotlin_tips_mvvm.mvvm.ContentViewModel
import java.util.*
import kotlin.collections.ArrayList

class ContentAdapter(val context: Context, private val list: ArrayList<Content>):RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemContentBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        var time = Calendar.getInstance()
        time.timeInMillis = item.time

        holder.binding.run {
            tvName.text = item.name
            tvContent.text = item.text
            tvTime.text = time.format("yyyy/MM/dd HH:mm")
        }
    }

    override fun getItemCount() = list.size

}