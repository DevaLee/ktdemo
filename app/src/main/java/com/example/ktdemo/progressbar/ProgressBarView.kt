package com.example.ktdemo.progressbar

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatImageView
import java.util.jar.Attributes


class RoundCornerImageView (context: Context, attrs: Attributes?, defStyle: Int?) : AppCompatImageView(context) {

    private var mRadius :Float = 18.0f
    private var mClipPath = Path();
    private var mRect = RectF()

    constructor(context: Context): this(context, null, null) {

    }
    public fun setRadiusDp(dp: Float) {
        mRadius = dp2px(dp, resources)
    }

    fun setRadiusPx(px: Int) {
        mRadius = px.toFloat();
        postInvalidate();
    }

    override fun onDraw(canvas: Canvas?) {

        mRect.set(0f, 0f, width.toFloat(), height.toFloat());
        mClipPath.reset()
        mClipPath.addRoundRect(mRect, mRadius, mRadius, Path.Direction.CW)
        canvas?.clipPath(mClipPath)
        super.onDraw(canvas)
    }

    public fun updatePercent(percent: Int) {
        var mPercent = percent

    }

    private fun dp2px(value: Float, resources: Resources) :Float {

        return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics)
    }


}