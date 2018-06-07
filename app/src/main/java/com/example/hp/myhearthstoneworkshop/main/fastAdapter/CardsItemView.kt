package com.example.hp.myhearthstoneworkshop.main.fastAdapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.hp.myhearthstoneworkshop.R
import com.mikepenz.fastadapter.FastAdapter
import com.squareup.picasso.Picasso


class CardsItemView (itemView: View?, color: String): FastAdapter.ViewHolder<CardsItem>(itemView){

    val cardName: TextView?
    val manaCost: TextView?
    val imageView: ImageView?
    val currentColor = color

    init {
        cardName = itemView?.findViewById(R.id.cardName)
        manaCost = itemView?.findViewById(R.id.manaCost)
        imageView = itemView?.findViewById(R.id.druidButton)
    }

    override fun unbindView(item: CardsItem?) {
        cardName?.setText("")
        manaCost?.setText("")
        imageView?.setImageDrawable(null)
    }

    override fun bindView(item: CardsItem?, payloads: MutableList<Any>?) {
        val card = item?.news
        cardName?.setText(card?.name)
        manaCost?.setText(card?.cost.toString())
       Picasso.get().load(card?.img?: "http://media.services.zam.com/v1/media/byName/hs/cards/enus/AT_060.png").into(imageView)
        this.itemView.setBackgroundColor(Color.parseColor(this.currentColor))
    }

}