package com.example.hp.myhearthstoneworkshop.main.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class CardResultWrapper {
    var results:Array<Card> = emptyArray()
}
