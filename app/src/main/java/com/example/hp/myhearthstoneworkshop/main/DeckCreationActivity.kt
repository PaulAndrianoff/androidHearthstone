package com.example.hp.myhearthstoneworkshop.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.hp.myhearthstoneworkshop.R
import com.example.hp.myhearthstoneworkshop.main.fastAdapter.CardsItem
import com.example.hp.myhearthstoneworkshop.main.model.*
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_deck_creation.*


class DeckCreationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deck_creation)

        val bundle = intent.extras

        val title = "Les cartes de " + bundle.getString("class")
        titleView.text = title

        imageView?.setImageDrawable(null)

        imageView.setOnClickListener {
            imageView?.setImageDrawable(null)
        }

        val newParameters = mutableMapOf<String, String>()
        newParameters["X-Mashape-Key"] = "w5s7bFULLKmshAS0srC3JXNptkrkp1whi6EjsnVXVhe9yzE2NM"

        val url = "http://paulandrianoff.com/hunter.json"

        val request = BaseRequest.Builder<CardResultWrapper>(
                Request.Method.GET,
                url,
                CardResultWrapper::class.java
        )
                .listener(object : RequestListener<CardResultWrapper> {
                    override fun onSuccess(request: Request<*>?, response: NetworkResponse?, result: CardResultWrapper?) {
                        Toast.makeText(this@DeckCreationActivity, "A SUCCESS", Toast.LENGTH_SHORT).show()

                        if (result != null) {
                            // SUCCESS
                            val cardList = result.results
                            displayCards(cardList, bundle.getString("color"))
                            Toast.makeText(this@DeckCreationActivity, "success Json", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(request: Request<*>?, response: NetworkResponse?, error: VolleyError?) {
                        Toast.makeText(this@DeckCreationActivity, "Sorry. We couldn't retrieve your card", Toast.LENGTH_SHORT).show()
                            val cardList:Array<Card> = arrayOf(card1, card2, card3, card4, card5, card6, card7, card1, card2, card3, card4, card5, card6, card7, card1, card2, card3, card4, card5, card6, card7)
                            displayCards(cardList, bundle.getString("color"))
                    }
                })
                .parameters(newParameters)
                .build()

        hearthstoneApplication.shared.requestQueue.add(request)
    }

    fun displayCards(cardList: Array<Card>, color:String) {
        val monAdapter = FastItemAdapter<CardsItem>()
        for (cards: Card in cardList) {
            val item = CardsItem(cards, color)
            monAdapter.add(item)
        }
        println(monAdapter)

        cardsRecyclerView.adapter = monAdapter

        val monLinearLayoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        cardsRecyclerView.layoutManager = monLinearLayoutManager
        println(cardsRecyclerView)

        monAdapter.withOnClickListener({ view, adapter, item, position ->
//            val intent = Intent(this, NewsArticleActivity::class.java)
//            intent.putExtra("title", item.news.name)
//            startActivity(intent)

            Picasso.get().load(item?.news?.img).into(imageView)
            return@withOnClickListener true
        })
    }
}
