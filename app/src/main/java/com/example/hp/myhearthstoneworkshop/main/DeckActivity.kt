package com.example.hp.myhearthstoneworkshop.main.model

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hp.myhearthstoneworkshop.R
import kotlinx.android.synthetic.main.activity_news.*

class DeckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deck)

        newDeck.setOnClickListener {
            val intent = Intent(this, HerroesClassActivity::class.java)
            startActivity(intent)
        }
    }
}
