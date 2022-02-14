package com.sk.splash.ui.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.sk.splash.ui.R

class ContentDetailLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var iconView: ImageView
    private lateinit var keyView: TextView
    private lateinit var valueView: TextView

    private var icon: Drawable?
    private var key: String = ""
    private var value: String = ""

    init {
        inflate(context, R.layout.layout_content_detail, this)
        with(context.obtainStyledAttributes(attrs, R.styleable.ContentDetailLayout)) {
            icon = getDrawable(R.styleable.ContentDetailLayout_icon)
            key = getString(R.styleable.ContentDetailLayout_key) ?: ""
            value = getString(R.styleable.ContentDetailLayout_value) ?: ""
            recycle()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        iconView = findViewById(R.id.icon)
        keyView = findViewById(R.id.key)
        valueView = findViewById(R.id.value)

        iconView.setImageDrawable(icon)
        keyView.text = key
        valueView.text = value
    }

    fun setValue(string: String?) {
        isVisible = string.isNullOrEmpty().not()
        string?.let { valueView.text = string.toString() }
    }
}