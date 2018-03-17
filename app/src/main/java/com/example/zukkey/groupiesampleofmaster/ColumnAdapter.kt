package com.example.zukkey.groupiesampleofmaster

import android.databinding.ViewDataBinding
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.zukkey.groupiesampleofmaster.databinding.ItemCardBinding
import com.example.zukkey.groupiesampleofmaster.databinding.ItemHeaderBinding
import kotlinx.android.synthetic.main.item_card.view.*

class ColumnAdapter(private val items: MutableList<CardItem>): RecyclerView.Adapter<ColumnAdapter.ViewHolder>(){

    companion object ViewType {
        const val HEADER = 0
        const val CONTENT = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return when(viewType) {
           HEADER -> ViewHolder(ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
           else -> ViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
       }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder.binding is ItemHeaderBinding) {
            holder.binding.title.text = "Home"
            holder.binding.subTitle.text = "Home Sub Title"
        } else {
            with(holder.binding is ItemCardBinding) {
                holder.binding.root.item_fancy_number.setTextColor(ContextCompat.getColor(holder.binding.root.context, R.color.colorPrimaryDark))
            }
            holder.binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int = items.size + 1

    override fun getItemViewType(position: Int): Int = if (position == 0) ViewType.HEADER else ViewType.CONTENT

    class ViewHolder(val binding: ViewDataBinding):RecyclerView.ViewHolder(binding.root)
}
