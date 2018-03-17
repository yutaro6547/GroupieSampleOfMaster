package com.example.zukkey.groupiesampleofmaster

import com.xwray.groupie.Group
import com.xwray.groupie.GroupDataObserver
import com.xwray.groupie.Item
import com.xwray.groupie.NestedGroup


class ColumnGroup(items: List<Item<*>>) : NestedGroup() {

    private val items = ArrayList<Item<*>>()

    init {
        for (i in items.indices) {
            // Rearrange items so that the adapter appears to arrange them in vertical columns
            var index: Int
            if (i % 2 == 0) {
                index = i / 2
            } else {
                index = (i - 1) / 2 + (items.size / 2f).toInt()
                // If columns are uneven, we'll put an extra one at the end of the first column,
                // meaning the second column's indices will all be increased by 1
                if (items.size % 2 == 1) index++
            }
            val trackItem = items[index]
            this.items.add(trackItem)
        }
    }

    override fun getPosition(group: Group): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGroup(position: Int): Group {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGroupCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unregisterGroupDataObserver(groupDataObserver: GroupDataObserver) {
        // no need to do anything here
    }

    override fun getItem(position: Int): Item<*> {
        return items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

}