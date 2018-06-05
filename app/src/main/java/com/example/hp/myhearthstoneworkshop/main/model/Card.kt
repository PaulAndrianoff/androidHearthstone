package com.example.hp.myhearthstoneworkshop.main.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Card constructor(dbfId:Int = 0, name:String = "", img:String = "", text:String="", cardSet:String = "", type:String = "", attack:Int = 0, health:Int = 0, cost:Int = 0){
    val dbfId:Int = dbfId
    val name:String = name
    val img:String = img
    val text:String = text
    val cardSet:String = cardSet
    val type:String = type
    val cost:Int = cost
    val attack:Int = attack
    val health:Int = health
}