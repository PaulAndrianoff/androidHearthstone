package com.example.hp.myhearthstoneworkshop.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hp.myhearthstoneworkshop.R
import kotlinx.android.synthetic.main.activity_herroes_class.*

class HerroesClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_herroes_class)

        hunterButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Hunter")
            intent.putExtra("color", "#07881A")
            startActivity(intent)
        }

        shamanButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Shaman")
            intent.putExtra("color", "#0055BD")
            startActivity(intent)
        }

        mageButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Mage")
            intent.putExtra("color", "#07A8B0")
            startActivity(intent)
        }

        druidButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Druid")
            intent.putExtra("color", "#00A81C")
            startActivity(intent)
        }
        rogueButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Rogue")
            intent.putExtra("color", "#2E2E2E")
            startActivity(intent)
        }

        demonButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Warlock")
            intent.putExtra("color", "#9B00B3")
            startActivity(intent)
        }

        priestButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Priest")
            intent.putExtra("color", "#FFE875")
            startActivity(intent)
        }

        warriorButton.setOnClickListener {
            val intent = Intent(this, DeckCreationActivity::class.java)
            intent.putExtra("class", "Warrior")
            intent.putExtra("color", "#B30000")
            startActivity(intent)
        }
    }
}
