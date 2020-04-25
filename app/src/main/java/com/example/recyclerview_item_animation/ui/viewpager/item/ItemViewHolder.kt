package com.example.recyclerview_item_animation.ui.viewpager.item

import android.content.Context
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.recyclerview_item_animation.R
import com.example.recyclerview_item_animation.ui.viewpager.direction.DirectionPagerTransformer
import com.example.recyclerview_item_animation.utils.DrawableConstant

class ItemViewHolder(view: View) : DirectionPagerTransformer.DirectionViewHolder(view) {
    companion object {
        const val scaleFactor: Float = -0.06f
        const val shoeDefaultAngle: Float = -90f
        const val shoeMaxAngleDistance: Float = 60f
        const val maxRotationDistanceY = 6f
    }

    val cardviewContent: RelativeLayout = view.findViewById(R.id.cardviewContent)

    val cardviewItem: CardView = view.findViewById(R.id.cardviewItem)
    val imageViewItem: ImageView = view.findViewById(R.id.imageViewItem)

    val imageButtonForward: ImageButton = view.findViewById(R.id.imageButtonForward)
    val imageButtonChecked: ImageButton = view.findViewById(R.id.imageButtonChecked)

    override fun bind(baseViewModel: BaseViewModel, position: Int) {
        super.bind(baseViewModel, position)
        var itemViewModel = baseViewModel as ItemViewModel
        cardviewItem.setCardBackgroundColor(itemViewModel.color)
        imageViewItem.setImageDrawable(itemViewModel.image)

        imageButtonChecked.setOnClickListener {
            if (DrawableConstant.isTheSame(
                    DrawableConstant.getChecked(view.context),
                    imageButtonChecked.drawable
                )
            ) {
                imageButtonChecked.setImageDrawable(DrawableConstant.getChecked(view.context))
            } else {
                imageButtonChecked.setImageDrawable(DrawableConstant.getUnChecked(view.context))
            }
        }
    }

    fun cardViewAnim(scaleY: Float, rotationY: Float) {
        cardviewContent.scaleY = scaleY
        cardviewContent.rotationY = rotationY
    }

    fun showAnim(angle: Float, isVisibleHandle: Boolean = true) {
        val angleValue = shoeDefaultAngle + angle
        val angleDefaultValue = shoeDefaultAngle
        imageViewItem.rotation = angleValue

        if(isVisibleHandle){
            if (imageViewItem.rotation > shoeDefaultAngle && imageViewItem.rotation <= (shoeDefaultAngle + shoeMaxAngleDistance)) {
                imageViewItem.visibility = VISIBLE
            } else {
                imageViewItem.rotation = angleDefaultValue
                imageViewItem.visibility = GONE
            }
        }
    }

    fun changeColor(i: Float, context: Context) {
        if (i == 1f || i == -1f) {
            cardviewItem.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.cyan
                )
            )
        } else if (i < 0f) {
            cardviewItem.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.red
                )
            )
        } else if (i > 0f) {
            cardviewItem.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.blue
                )
            )
        }

    }
}