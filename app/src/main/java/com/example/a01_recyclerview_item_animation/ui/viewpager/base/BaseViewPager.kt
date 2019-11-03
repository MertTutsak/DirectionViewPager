package com.example.a01_recyclerview_item_animation.ui.viewpager.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager

open class BaseViewPager : ViewPager {

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
    }

    abstract class ViewHolder(var view: View) {
        abstract fun bind(baseViewModel: BaseViewModel, position: Int)

        abstract class BaseViewModel()
    }

}