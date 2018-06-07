package com.example.hp.myhearthstoneworkshop.main.fastAdapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.hp.myhearthstoneworkshop.R
import com.mikepenz.fastadapter.FastAdapter
import com.example.hp.myhearthstoneworkshop.main.model.imageArray

class NewsItemView(itemView: View?): FastAdapter.ViewHolder<NewsItem>(itemView){

    val titleTextView: TextView?
    val labelTextView: TextView?
    val imageView: ImageView?

    init {
        titleTextView = itemView?.findViewById(R.id.titleTextView)
        labelTextView = itemView?.findViewById(R.id.labelTextView)
        imageView = itemView?.findViewById(R.id.druidButton)
    }

    override fun unbindView(item: NewsItem?) {
        titleTextView?.setText("")
        labelTextView?.setText("")
        imageView?.setImageDrawable(null)
    }

    override fun bindView(item: NewsItem?, payloads: MutableList<Any>?) {
        val news = item?.news
        titleTextView?.setText(news?.title)
        labelTextView?.setText(news?.label)
        imageView?.setImageResource(imageArray[news?.imageId?: 0])
    }

}