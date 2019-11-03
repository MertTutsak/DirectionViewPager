package com.example.a01_recyclerview_item_animation.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.a01_recyclerview_item_animation.R

object DrawableConstant {
    fun getChecked(context: Context): Drawable {
        return ContextCompat.getDrawable(
            context,
            R.drawable.ic_checked
        )!!
    }

    fun getUnChecked(context: Context): Drawable {
        return ContextCompat.getDrawable(
            context,
            R.drawable.ic_unchecked
        )!!
    }

    fun getForward(context: Context): Drawable {
        return ContextCompat.getDrawable(
            context,
            R.drawable.ic_forward
        )!!
    }

    fun getShoe(context: Context): Drawable {
        return ContextCompat.getDrawable(
            context,
            R.mipmap.shoe
        )!!
    }

    fun isTheSame(drawableA :Drawable, drawableB: Drawable):Boolean {
        return drawableA != drawableB
    }
}