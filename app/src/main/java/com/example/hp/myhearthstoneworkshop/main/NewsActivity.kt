package com.example.hp.myhearthstoneworkshop.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hp.myhearthstoneworkshop.R
import com.example.hp.myhearthstoneworkshop.main.fastAdapter.NewsItem
import com.example.hp.myhearthstoneworkshop.main.model.News
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_news.*


class NewsActivity : AppCompatActivity() {

    private val new1 = News("titre 1", "mon subtitle", "Blaize parle beaucoup trop avec les profs.", "deck", 2)
    private val news2 = News("titre 2", "mon super subtitle", "Octave à encore blamé Blaize.", "deck", 3)
    private val listOfNews:Array<News> = arrayOf(new1, news2, new1, news2, new1, news2, new1, news2, new1, news2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        displayNews(listOfNews)

        newDeck.setOnClickListener {
            val intent = Intent(this, HerroesClassActivity::class.java)
            startActivity(intent)
        }

        myDecks.setOnClickListener {
            val intent = Intent(this, DeckActivity::class.java)
            startActivity(intent)
        }

    }

    fun displayNews(listOfNews: Array<News>) {
        val monAdapter = FastItemAdapter<NewsItem>()
        for (news: News in listOfNews) {
            val item = NewsItem(news)
            monAdapter.add(item)
        }

        newRecyclerView.adapter = monAdapter

        val monLinearLayoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        newRecyclerView.layoutManager = monLinearLayoutManager

        monAdapter.withOnClickListener({ view, adapter, item, position ->
            val intent = Intent(this, NewsArticleActivity::class.java)
            intent.putExtra("title", item.news.title)
            intent.putExtra("subtitle", item.news.subtitle)
            intent.putExtra("content", item.news.content)
            intent.putExtra("label", item.news.label)
            intent.putExtra("imageId", item.news.imageId)
            startActivity(intent)
            return@withOnClickListener true
        })
    }
}
