package com.example.recyclerview_item_animation.ui.viewpager.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager

open class BaseViewPager : ViewPager {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    abstract class ViewHolder(var view: View) {
        abstract fun bind(baseViewModel: BaseViewModel, position: Int)

        abstract class BaseViewModel()
    }

}