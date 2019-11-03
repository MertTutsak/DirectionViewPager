package com.example.a01_recyclerview_item_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a01_recyclerview_item_animation.ui.viewpager.item.ItemViewModel
import com.example.a01_recyclerview_item_animation.ui.viewpager.PagerTransformerShift
import com.example.a01_recyclerview_item_animation.ui.viewpager.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val items = ArrayList<ItemViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*initRecyclerview()*/
        initViewPager()
    }

    private fun getDummy(): ArrayList<ItemViewModel> {
        if (items.isEmpty()) {
            items.add(
                ItemViewModel(
                    MainActivity@ this,
                    ItemViewModel.ItemType.CYAN
                )
            )
            items.add(
                ItemViewModel(
                    MainActivity@ this,
                    ItemViewModel.ItemType.BLUE
                )
            )
            items.add(
                ItemViewModel(
                    MainActivity@ this,
                    ItemViewModel.ItemType.RED
                )
            )
            items.add(
                ItemViewModel(
                    MainActivity@ this,
                    ItemViewModel.ItemType.CYAN
                )
            )
            items.add(
                ItemViewModel(
                    MainActivity@ this,
                    ItemViewModel.ItemType.BLUE
                )
            )
            items.add(
                ItemViewModel(
                    MainActivity@ this,
                    ItemViewModel.ItemType.RED
                )
            )
        }
        return items
    }

    private fun initViewPager() {
        viewPager.clipChildren = false
        viewPager.clipToPadding = false

        val padding = 90
        viewPager.pageMargin = 0
        viewPager.setPadding(0, 0, (padding * 2).toInt(), 0)
        viewPager.setPageTransformer(
            false, PagerTransformerShift()
        )
        viewPager.adapter = getViewPagerAdapter()
    }

    private fun getViewPagerAdapter(): ViewPagerAdapter {
        return ViewPagerAdapter(
            MainActivity@ this,
            getDummy()
        )
    }
}
