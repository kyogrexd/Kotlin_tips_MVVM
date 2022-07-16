package com.example.kotlin_tips_mvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_tips_mvvm.data.Content
import com.example.kotlin_tips_mvvm.model.ContentRepository

class ContentViewModel: ViewModel() {

    private val contentRepository = ContentRepository()

    fun saveText(content: Content) {
        contentRepository.addContent(content)
    }

    fun getContentList() = contentRepository.getContentList()

    private val _content = MutableLiveData<ArrayList<Content>>()
    val content: LiveData<ArrayList<Content>> get() = _content

    fun addList(content: Content) {
        _content.value = contentRepository.addList(content)
    }
}