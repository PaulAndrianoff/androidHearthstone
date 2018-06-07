package com.example.hp.myhearthstoneworkshop.main.model

import com.example.hp.myhearthstoneworkshop.R

// Heroes Images
val imageArray = arrayListOf(R.drawable.chaman,
        R.drawable.demon,
        R.drawable.druid,
        R.drawable.hunter,
        R.drawable.mage,
        R.drawable.priest,
        R.drawable.rogue,
        R.drawable.warrior)

// Some card used if there is a network error
val card1 = Card(0,"Bear Trap", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/AT_060.png", "<b>Secret:</b> After your hero is attacked, summon a 3/3 Bear with <b>Taunt</b>.", "The Grand Tournament", "spell", 0, 0, 2)
val card2 = Card(0,"Crackling Razormaw", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/UNG_915.png", "<b>Battlecry:</b> <b>Adapt</b> a friendly_Beast.", "Journey to Un'Goro", "Minion", 3, 2, 2)
val card3 = Card(0,"Dart Trap", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/LOE_021.png", "<b>Secret:</b> After an opposing Hero Power is used, deal \$5 damage to a random enemy.", "The League of Explorers", "spell", 0, 0, 2)
val card4 = Card(0,"Explosive Trap", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_610.png", "<b>Secret:</b> When your hero is attacked, deal \$2 damage to all enemies.", "Classic", "spell", 0, 0, 2)
val card5 = Card(0,"Freezing Trap", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_611.png", "<b>Secret:</b> When an enemy minion attacks, return it to its owner's hand. It costs (2) more.", "Classic", "spell", 0, 0, 2)
val card6 = Card(0,"Animal Companion", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_031.png", "Summon a random Beast Companion.", "Classic", "spell", 0, 0, 3)
val card7 = Card(0,"Bearshark", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/ICC_419.png", "Can't be targeted by spells or Hero Powers.", "Knights of the Frozen Throne", "Minion", 4, 3, 3)

val allCard = arrayOf(card1, card2, card3, card4, card5, card6, card7)

val allDeck: ArrayList<Deck> = ArrayList()

