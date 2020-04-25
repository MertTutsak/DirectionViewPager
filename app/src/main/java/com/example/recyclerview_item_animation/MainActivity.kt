package com.example.recyclerview_item_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview_item_animation.ui.viewpager.item.ItemViewModel
import com.example.recyclerview_item_animation.ui.viewpager.PagerTransformerShift
import com.example.recyclerview_item_animation.ui.viewpager.ViewPagerAdapter
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
                    this@MainActivity,
                    ItemViewModel.ItemType.CYAN
                )
            )
            items.add(
                ItemViewModel(
                    this@MainActivity,
                    ItemViewModel.ItemType.BLUE
                )
            )
            items.add(
                ItemViewModel(
                    this@MainActivity,
                    ItemViewModel.ItemType.RED
                )
            )
            items.add(
                ItemViewModel(
                    this@MainActivity,
                    ItemViewModel.ItemType.CYAN
                )
            )
            items.add(
                ItemViewModel(
                    this@MainActivity,
                    ItemViewModel.ItemType.BLUE
                )
            )
            items.add(
                ItemViewModel(
                    this@MainActivity,
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
            this@MainActivity,
            getDummy()
        )
    }
}
