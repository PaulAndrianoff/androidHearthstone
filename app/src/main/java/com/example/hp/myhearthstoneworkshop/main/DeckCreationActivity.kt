package com.example.hp.myhearthstoneworkshop.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
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

    val cardDeckList:Deck = Deck()
    var deckIndex = 0
    var getCardAUTH = 0 // 0 if we didn't already have neutral card
    var classCardsAll:Array<Card> = emptyArray()
    var neutralCardsAll:Array<Card> = emptyArray()
    val neutralColor:String = "#766955"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deck_creation)

        val bundle = intent.extras

        val title = "Les cartes de " + bundle.getString("class")
        titleView.text = title

        imageView?.setImageDrawable(null)
        imageView?.setVisibility(View.GONE)


        // Add cardDeckList to allDeck array
        cardDeckList.heroe = bundle.getString("class")
        allDeck.add(cardDeckList)
        deckIndex = allDeck.size-1

        allDeck[deckIndex].name = deckLabel.getText().toString()

        /*--------------------------------------------------------------

            Get JSON on Network

        --------------------------------------------------------------*/
        // Get Neutral Cards
        val urlNeutral = "http://paulandrianoff.com/neutral.json"
        val requestNeutralCard = BaseRequest.Builder<CardResultWrapper>(
                Request.Method.GET,
                urlNeutral,
                CardResultWrapper::class.java
        ) .listener(object : RequestListener<CardResultWrapper> {
            override fun onSuccess(request: Request<*>?, response: NetworkResponse?, result:  CardResultWrapper) {
                Toast.makeText(this@DeckCreationActivity, "A SUCCESS", Toast.LENGTH_SHORT).show()

                if (result != null) {
                    // SUCCESS
                    val listOfCard = result.results
                    displayCards(listOfCard, neutralColor)
                    neutralCardsAll = listOfCard
                }
            }

            override fun onFailure(request: Request<*>?, response: NetworkResponse?, error: VolleyError?) {
                Toast.makeText(this@DeckCreationActivity, "SORRY WE COULD'NT GET THE CARDS", Toast.LENGTH_SHORT).show()
            }
        })
                .build()

        // Get Class Cards
        val urlClass = "http://paulandrianoff.com/" + bundle.getString("class").toLowerCase() + ".json"
        val requestClassCard = BaseRequest.Builder<CardResultWrapper>(
                Request.Method.GET,
                urlClass,
                CardResultWrapper::class.java
        )
                .listener(object : RequestListener<CardResultWrapper> {
                    override fun onSuccess(request: Request<*>?, response: NetworkResponse?, result:  CardResultWrapper) {
                        Toast.makeText(this@DeckCreationActivity, "A SUCCESS", Toast.LENGTH_SHORT).show()

                        if (result != null) {
                            // SUCCESS
                            val listOfCard = result.results
                            displayCards(listOfCard, bundle.getString("color"))
                            classCardsAll = listOfCard
                        }
                    }

                    override fun onFailure(request: Request<*>?, response: NetworkResponse?, error: VolleyError?) {
                        Toast.makeText(this@DeckCreationActivity, "SORRY WE COULD'NT GET THE CARDS", Toast.LENGTH_SHORT).show()
                    }
                })
                .build()

        hearthstoneApplication.shared.requestQueue.add(requestClassCard)

        // Image disapear
        imageView.setOnClickListener {
            imageView?.setImageDrawable(null)
            imageView?.setVisibility(View.GONE)
        }

        // Button Listener
        classCards.setOnClickListener {
            displayCards(classCardsAll, bundle.getString("color"))
        }

        neutralCards.setOnClickListener {
            if (getCardAUTH == 0) {
                hearthstoneApplication.shared.requestQueue.add(requestNeutralCard)
                getCardAUTH = 1
            } else {
                displayCards(neutralCardsAll, neutralColor)
            }
        }
    }


fun displayCards(cardList: Array<Card>, color:String) {
        val monAdapter = FastItemAdapter<CardsItem>()
        for (cards: Card in cardList) {
            val item = CardsItem(cards, color)
            monAdapter.add(item)
        }

        progressBar.setVisibility(View.GONE)


            cardsClassRecyclerView.adapter = monAdapter

            val monLinearLayoutManager = LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL,
                    false)
            cardsClassRecyclerView.layoutManager = monLinearLayoutManager

        monAdapter.withOnClickListener({ view, adapter, item, position ->
//            val intent = Intent(this, NewsArticleActivity::class.java)
            val contains = allDeck[deckIndex].cardList.keys.any { key ->
                allDeck[deckIndex].cardList.put(key, 2)
                true
            }
            if (!contains) {
                allDeck[deckIndex].cardList.put(item.news.name, 1)
            }
            println(allDeck)

            return@withOnClickListener true
        })

        monAdapter.withOnLongClickListener({ view, adapter, item, position ->
            imageView.setVisibility(View.VISIBLE)
            Picasso.get().load(item.news.img).into(imageView)
            Toast.makeText(this, allDeck[deckIndex].name, Toast.LENGTH_SHORT).show()
            return@withOnLongClickListener true
        })
    }
}
