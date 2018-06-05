package com.example.hp.myhearthstoneworkshop.main.model

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import com.example.hp.myhearthstoneworkshop.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Link to NewsActivity **/
        newsButton.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }

        decksButton.setOnClickListener {
            val intent = Intent(this, DeckActivity::class.java)
            startActivity(intent)
        }
    }
}
