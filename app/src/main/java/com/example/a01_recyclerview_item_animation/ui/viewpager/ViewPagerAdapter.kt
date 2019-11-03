package com.example.a01_recyclerview_item_animation.ui.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.a01_recyclerview_item_animation.R
import com.example.a01_recyclerview_item_animation.ui.viewpager.item.ItemViewHolder
import com.example.a01_recyclerview_item_animation.ui.viewpager.item.ItemViewModel

class ViewPagerAdapter(
    val context: Context,
    val itemModels: ArrayList<ItemViewModel>
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val holder = ItemViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_view,
                container,
                false
            )
        )

        holder.bind(itemModels[position], position)

        container.addView(holder.view)
        return holder.view
    }

    override fun getCount(): Int {
        return itemModels!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}