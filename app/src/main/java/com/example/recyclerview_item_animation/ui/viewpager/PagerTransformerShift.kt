package com.example.recyclerview_item_animation.ui.viewpager

import android.view.View
import com.example.recyclerview_item_animation.ui.viewpager.direction.DirectionPagerTransformer
import com.example.recyclerview_item_animation.ui.viewpager.item.ItemViewHolder
import kotlin.math.abs

class PagerTransformerShift() : DirectionPagerTransformer() {

    override fun onTransform(page: View, position: Float) {
        var holder = (getHolder(page) as ItemViewHolder)
        val pageWidth = holder.view.width

        val absPosition = abs(position)

        val angle = 60.0f

        //Durumlarını anlamak için yapılmıştır.
        /*holder.changeColor(position, page.context)*/

        if (holder.direction == ViewPagerDirection.FROM_RIGHT) {
            if (absPosition >= 0.9) {
                holder.cardViewAnim(
                    ItemViewHolder.scaleFactor * absPosition + 1,
                    (-ItemViewHolder.maxRotationDistanceY * ((1f - (absPosition * 10f - 9f)) / 1f))
                )
            } else if (absPosition >= 0.4) {
                holder.cardViewAnim(
                    ItemViewHolder.scaleFactor * absPosition + 1,
                    ((-ItemViewHolder.maxRotationDistanceY) - ((-ItemViewHolder.maxRotationDistanceY) * ((5f - (absPosition * 10f - 4f)) / 5f)))
                )
            } else if (absPosition >= 0.2) {
                holder.cardViewAnim(
                    ItemViewHolder.scaleFactor * absPosition + 1,
                    (ItemViewHolder.maxRotationDistanceY / 2f) * ((2f - (absPosition * 10f - 2f)) / 2f)
                )
            } else {
                holder.cardViewAnim(
                    ItemViewHolder.scaleFactor * absPosition + 1,
                    ((ItemViewHolder.maxRotationDistanceY / 2f) - ((ItemViewHolder.maxRotationDistanceY / 2f) * ((2f - (absPosition * 10f - 0f)) / 2f)))
                )
            }
        } else if (holder.direction == ViewPagerDirection.TO_LEFT) {
            holder.cardViewAnim(
                ItemViewHolder.scaleFactor * absPosition + 1,
                (ItemViewHolder.maxRotationDistanceY * (absPosition))
            )
        } else {
            holder.cardViewAnim(
                ItemViewHolder.scaleFactor * absPosition + 1,
                0.0f
            )
        }



        if (
            ((holder.direction == ViewPagerDirection.FROM_RIGHT) || (holder.direction == ViewPagerDirection.FROM_LEFT) || (holder.direction == ViewPagerDirection.NONE))
        ) {
            holder.showAnim(
                angle * (1 - absPosition)
            )
            holder.imageViewItem.translationX = ((absPosition) * (pageWidth / 3f) - 30)
        } else if ((holder.direction == ViewPagerDirection.CENTER)) {
            holder.showAnim(
                angle
            )
        } else if (holder.direction == ViewPagerDirection.TO_LEFT || (holder.direction == ViewPagerDirection.TO_RIGHT)) {
            holder.imageViewItem.translationX = holder.imageViewItem.x * 1.1f
        } else { //Durma durumu
            holder.showAnim(
                0f
            )
        }

    }


}