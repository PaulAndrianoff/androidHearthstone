package com.example.hp.myhearthstoneworkshop.main.fastAdapter

import android.view.View
import com.example.hp.myhearthstoneworkshop.R
import com.example.hp.myhearthstoneworkshop.main.model.News
import com.mikepenz.fastadapter.items.AbstractItem

class NewsItem(val news: News): AbstractItem<NewsItem, NewsItemView>() {

    override fun getType(): Int {
        return 0
    }

    override fun getViewHolder(itemView: View?): NewsItemView {
        val cell = NewsItemView(itemView)
        return cell
    }

    override fun getLayoutRes(): Int {
        return R.layout.news_item
    }

}