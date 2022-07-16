package com.example.kotlin_tips_mvvm.model

import androidx.lifecycle.MutableLiveData
import com.example.kotlin_tips_mvvm.data.Content

class ContentRepository {
    companion object {
        private var contentList = ArrayList<Content>()
    }

    fun addContent(content: Content) {
        contentList.add(content)
    }

    fun getContentList() = contentList

    fun addList(content: Content): ArrayList<Content> {
        contentList.add(content)
        return contentList
    }
}