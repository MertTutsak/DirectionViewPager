package com.example.recyclerview_item_animation.ui.viewpager.item;

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.recyclerview_item_animation.R
import com.example.recyclerview_item_animation.ui.viewpager.base.BaseViewPager

data class ItemViewModel(val context: Context, val type: ItemType) :
    BaseViewPager.ViewHolder.BaseViewModel() {
    var color: Int
    var image: Drawable

    init {
        when (type) {
            ItemType.BLUE -> {
                color = ContextCompat.getColor(
                    context,
                    R.color.blue
                )
                image = ContextCompat.getDrawable(
                    context,
                    R.mipmap.shoe
                )!!

            }
            ItemType.RED -> {
                color = ContextCompat.getColor(
                    context,
                    R.color.red
                )
                image = ContextCompat.getDrawable(
                    context,
                    R.mipmap.shoe
                )!!
            }
            ItemType.CYAN -> {
                color = ContextCompat.getColor(
                    context,
                    R.color.cyan
                )
                image = ContextCompat.getDrawable(
                    context,
                    R.mipmap.shoe
                )!!
            }
        }

    }

    enum class ItemType {
        BLUE {
            override fun signal() =
                BLUE
        },

        CYAN {
            override fun signal() =
                CYAN
        },

        RED {
            override fun signal() =
                RED
        };

        abstract fun signal(): ItemType
    }
}
