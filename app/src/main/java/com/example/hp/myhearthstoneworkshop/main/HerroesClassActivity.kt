package com.example.hp.myhearthstoneworkshop.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hp.myhearthstoneworkshop.R
import com.example.hp.myhearthstoneworkshop.R.id.*
import kotlinx.android.synthetic.main.activity_herroes_class.*

class HerroesClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_herroes_class)

        hunterButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Hunter")
            intent.putExtra("color", "#295121")
            startActivity(intent)
        }

        shamanButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Shaman")
            intent.putExtra("color", "#222645")
            startActivity(intent)
        }

        mageButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Mage")
            intent.putExtra("color", "#5C6793")
            startActivity(intent)
        }

        druidButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Druid")
            intent.putExtra("color", "#623E25")
            startActivity(intent)
        }
        rogueButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Rogue")
            intent.putExtra("color", "#38393D")
            startActivity(intent)
        }

        demonButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Warlock")
            intent.putExtra("color", "#6A3F76")
            startActivity(intent)
        }

        priestButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Priest")
            intent.putExtra("color", "#9FACB5")
            startActivity(intent)
        }

        warriorButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Warrior")
            intent.putExtra("color", "#742718")
            startActivity(intent)
        }

        palladinButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Paladin")
            intent.putExtra("color", "#D6AA4A")
            startActivity(intent)
        }
    }
}
