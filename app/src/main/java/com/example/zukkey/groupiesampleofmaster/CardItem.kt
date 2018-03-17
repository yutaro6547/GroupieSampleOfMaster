package com.example.zukkey.groupiesampleofmaster

import android.support.annotation.ColorInt
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_card.*


class CardItem(@ColorInt private val color: Int,
               private val number: Int) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.item_fancy_cardView.setCardBackgroundColor(color)
        viewHolder.item_fancy_number.text = number.toString()
    }

    override fun getLayout(): Int = R.layout.item_card

    override fun getSpanSize(spanCount: Int, position: Int): Int = spanCount / 3

}