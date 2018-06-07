package com.example.hp.myhearthstoneworkshop.main.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class CardSet {
    var cards:Array<Card> = arrayOf(Card())
}