package com.example.hp.myhearthstoneworkshop.main.fastAdapter

import android.view.View
import com.example.hp.myhearthstoneworkshop.R
import com.example.hp.myhearthstoneworkshop.main.model.Card
import com.mikepenz.fastadapter.items.AbstractItem

class CardsItem (val news: Card, currentColor: String): AbstractItem<CardsItem, CardsItemView>() {
    val currentColor = currentColor

    override fun getType(): Int {
        return 0
    }

    override fun getViewHolder(itemView: View?): CardsItemView {
        val cell = CardsItemView(itemView, this.currentColor)
        return cell
    }

    override fun getLayoutRes(): Int {
        return R.layout.cards_item
    }

}