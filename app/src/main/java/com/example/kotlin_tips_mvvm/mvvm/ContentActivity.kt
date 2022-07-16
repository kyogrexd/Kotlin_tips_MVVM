package com.example.kotlin_tips_mvvm.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_tips_mvvm.Method
import com.example.kotlin_tips_mvvm.adapter.ContentAdapter
import com.example.kotlin_tips_mvvm.data.Content
import com.example.kotlin_tips_mvvm.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    private lateinit var adapter: ContentAdapter
    private val contentViewModel by viewModels<ContentViewModel>()
    private var list = ArrayList<Content>()

    private var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras ?: return
        name = b.getString("Name", "")

        initView()
        initAdapter()
        initObserver()
        Method.showKeyBoard(this, binding.edInput)
    }

    private fun initView() {
        binding.run {
            tvEnter.setOnClickListener {
                val inputText = edInput.text.toString()
                val now = System.currentTimeMillis()

                Method.hideKeyBoard(this@ContentActivity, binding.edInput)
                edInput.text.clear()

                contentViewModel.addList(Content(name, inputText, now))
            }
        }
    }

    private fun initAdapter() {
        adapter = ContentAdapter(this, list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun initObserver() {
        contentViewModel.content.observe(this) {
            list.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }
}