package com.example.hp.myhearthstoneworkshop.main.fastAdapter

import android.view.View
import android.widget.TextView
import com.example.hp.myhearthstoneworkshop.R
import com.mikepenz.fastadapter.FastAdapter

class NewsItemView(itemView: View?): FastAdapter.ViewHolder<NewsItem>(itemView){

    val titleTextView: TextView?
    val subtitleTextView: TextView?

    init {
        titleTextView = itemView?.findViewById(R.id.titleTextView)
        subtitleTextView = itemView?.findViewById(R.id.subtitleTextView)
    }

    override fun unbindView(item: NewsItem?) {
        titleTextView?.setText("")
        subtitleTextView?.setText("")
    }

    override fun bindView(item: NewsItem?, payloads: MutableList<Any>?) {
        val contact = item?.news
        titleTextView?.setText(contact?.title)
        subtitleTextView?.setText(contact?.subtitle)
    }

}