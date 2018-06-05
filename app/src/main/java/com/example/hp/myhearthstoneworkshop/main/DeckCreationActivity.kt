package com.example.hp.myhearthstoneworkshop.main.model

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.VolleyError
import com.example.hp.myhearthstoneworkshop.R
import com.example.hp.myhearthstoneworkshop.main.fastAdapter.CardsItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.neopixl.spitfire.listener.RequestListener
import com.neopixl.spitfire.request.BaseRequest
import kotlinx.android.synthetic.main.activity_deck_creation.*

class DeckCreationActivity : AppCompatActivity() {

   // val card1 = Card("Hunter", "Kill Command", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_539.png", "Deal \$3 damage. If you control a Beast, deal\\n\$5 damage instead.", "Basic", 0, 0, "spell", 3)
    //val cardList:Array<Card> = arrayOf(card1, card1, card1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deck_creation)

        val newParameters = mutableMapOf<String, String>()

        val request = BaseRequest.Builder<CardResultWrapper>(
                Request.Method.GET,
                "http://paulandrianoff.com/hunter.json",
                CardResultWrapper::class.java
        )
                .listener(object : RequestListener<CardResultWrapper> {
                    override fun onSuccess(request: Request<*>?, response: NetworkResponse?, result: CardResultWrapper?) {
                        Toast.makeText(this@DeckCreationActivity, "A SUCCESS", Toast.LENGTH_SHORT).show()

                        if (result != null) {
                            // SUCCESS
                            val cardList = result.results
                            displayCards(cardList)
                        }
                    }

                    override fun onFailure(request: Request<*>?, response: NetworkResponse?, error: VolleyError?) {
                        Toast.makeText(this@DeckCreationActivity, "Sorry. We couldn't retrieve your card", Toast.LENGTH_SHORT).show()
                    }
                })
                .parameters(newParameters)
                .build()

        hearthstoneApplication.shared.requestQueue.add(request)
    }

    fun displayCards(cardList: Array<Card>) {
        val monAdapter = FastItemAdapter<CardsItem>()
        for (cards: Card in cardList) {
            val item = CardsItem(cards)
            monAdapter.add(item)
        }
        println(monAdapter)

        cardsRecyclerView.adapter = monAdapter

        val monLinearLayoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)
        cardsRecyclerView.layoutManager = monLinearLayoutManager
        println(cardsRecyclerView)

    /*    monAdapter.withOnClickListener({ view, adapter, item, position ->
            val intent = Intent(this, NewsArticleActivity::class.java)
            intent.putExtra("title", item.news.name)
            startActivity(intent)
            return@withOnClickListener true
        }) */
    }
}
