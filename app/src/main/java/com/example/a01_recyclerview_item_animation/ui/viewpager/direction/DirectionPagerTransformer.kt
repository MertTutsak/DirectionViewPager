package com.example.a01_recyclerview_item_animation.ui.viewpager.direction

import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.a01_recyclerview_item_animation.ui.viewpager.item.ItemViewHolder
import com.example.a01_recyclerview_item_animation.ui.viewpager.base.BaseViewPager
import java.util.ArrayList

abstract class DirectionPagerTransformer : ViewPager.PageTransformer {
    val startOffset: Float = 0f

    var holderList = ArrayList<DirectionViewHolder>()

    abstract fun onTransform(page: View, position: Float)

    override fun transformPage(page: View, position: Float) {
        setDirection(getHolder(page), position)
        onTransform(page, position)
        addHolder(getHolder(page))
    }
     open class DirectionViewHolder(view: View) : BaseViewPager.ViewHolder(view) {
        var direction: ViewPagerDirection =
            ViewPagerDirection.NONE

        var state: ViewPagerState =
            ViewPagerState.NONE

        override fun bind(viewModel: BaseViewModel, position: Int) {

        }

        var lastPosition: Float = -1f
    }

    protected fun getHolder(page: View): DirectionViewHolder {
        holderList.forEach {
            if (it.view == page) {
                return it
            }
        }

        return ItemViewHolder(page)
    }

    protected fun addHolder(holder: DirectionViewHolder) {
        if (!holderList.contains(holder)) {
            holderList.add(holder)
        } else {
            var index = holderList.indexOf(holder)
            holderList[index] = holder
        }
    }

    protected fun setDirection(holder: DirectionViewHolder, position: Float) {
        if (holder.lastPosition == position) {
            holder.state == ViewPagerState.STABLE
            return
        }

        if (position <= -1f) {
            holder.direction = ViewPagerDirection.ON_LEFT
            holder.state == ViewPagerState.STABLE
        } else if (position >= 1f) {
            holder.direction = ViewPagerDirection.ON_RIGHT
            holder.state == ViewPagerState.STABLE
        } else if (position < 0) {
            if (position > holder.lastPosition) {
                holder.direction = ViewPagerDirection.FROM_LEFT
                holder.state == ViewPagerState.MOVE
            } else if (position < holder.lastPosition) {
                holder.direction = ViewPagerDirection.TO_LEFT
                holder.state == ViewPagerState.MOVE
            }
        } else if (position > 0) {
            if (position >= holder.lastPosition) {
                holder.direction = ViewPagerDirection.TO_RIGHT
                holder.state == ViewPagerState.MOVE
            } else if (position < holder.lastPosition) {
                holder.direction = ViewPagerDirection.FROM_RIGHT
                holder.state == ViewPagerState.MOVE
            }
        } else {
            holder.direction = ViewPagerDirection.CENTER
            holder.state == ViewPagerState.STABLE
        }
        holder.lastPosition = position
    }

    enum class ViewPagerState {
        STABLE,
        MOVE,
        NONE
    }

    enum class ViewPagerDirection {
        TO_LEFT,
        ON_LEFT,
        FROM_LEFT,
        TO_RIGHT,
        FROM_RIGHT,
        ON_RIGHT,
        CENTER,
        NONE
    }
}