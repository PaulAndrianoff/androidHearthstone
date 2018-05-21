package com.example.hp.myhearthstoneworkshop.main.model

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hp.myhearthstoneworkshop.R
import kotlinx.android.synthetic.main.activity_news_article.*

class NewsArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_article)

        val bundle = intent.extras

        titleTextView.text = bundle.getString("title")
        subtitleTextView.text = bundle.getString("subtitle")
        contentTextView.text = bundle.getString("content")
    }
}
