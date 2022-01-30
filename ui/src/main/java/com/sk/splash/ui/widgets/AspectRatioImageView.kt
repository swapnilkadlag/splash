package com.sk.splash.ui.widgets

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.imageview.ShapeableImageView

class AspectRatioImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ShapeableImageView(context, attrs, defStyleAttr) {

    private var aspectRatio: Float = 0f

    fun setAspectRatio(ratio: Float) {
        aspectRatio = ratio
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if(aspectRatio <= 0) return
        val width = measuredWidth
        val height = (aspectRatio * width).toInt()
        setMeasuredDimension(width, height)
    }
}