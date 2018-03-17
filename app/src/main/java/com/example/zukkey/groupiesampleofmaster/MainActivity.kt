package com.example.zukkey.groupiesampleofmaster

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.zukkey.groupiesampleofmaster.databinding.ActivityMainBinding
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import java.util.*

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            spanCount = 3
        }

        val cardItem = generateCards(12)

        ExpandableGroup(ExpandableHeaderItem("Expandable Group"), true).apply {
            add(Section(cardItem))
            groupAdapter.add(this)
        }

        Section(HeaderItem(R.string.test_title, R.string.test_subtitle)).apply {
            add(ColumnGroup(cardItem))
            groupAdapter.add(this)
        }


        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, groupAdapter.spanCount).apply {
                spanSizeLookup = groupAdapter.spanSizeLookup
            }
            adapter = groupAdapter
        }

    }


    private fun generateCards(count: Int): MutableList<CardItem> {
        val rnd = Random()
        return MutableList(count) {
            val color = Color.argb(255, rnd.nextInt(256),
                    rnd.nextInt(256), rnd.nextInt(256))
            CardItem(color, rnd.nextInt(100))
        }
    }
}
