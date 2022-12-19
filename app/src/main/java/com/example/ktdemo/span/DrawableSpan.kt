package com.example.ktdemo.span

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.text.style.ReplacementSpan

class DrawableSpan ( val drawer: Drawable): ReplacementSpan() {
    private val padding = Rect()
    var textColor = Color.parseColor("#3792e5")

    init {
        drawer.getPadding(padding)
    }

    override fun getSize(
        paint: Paint,
        text: CharSequence?,
        start: Int,
        end: Int,
        fm: Paint.FontMetricsInt?
    ): Int {

        return  paint.measureText(text,start, end).toInt()
    }

    override fun draw(
        canvas: Canvas,
        text: CharSequence?,
        start: Int,
        end: Int,
        x: Float,
        top: Int,
        y: Int,
        bottom: Int,
        paint: Paint
    ) {
        val rect = RectF(x, top.toFloat(),x + paint.measureText(text,start, end).toFloat(),bottom.toFloat())
        drawer.setBounds(rect.left.toInt() - padding.left.toInt(),rect.top.toInt() - padding.top.toInt(),rect.right.toInt() + padding.right.toInt(), (rect.bottom.toInt() + rect.height() / 1.2f).toInt())
        paint.color = textColor
        canvas.drawText(text ?: "",start,end,x, y.toFloat(), paint)
        drawer.draw(canvas)
    }
}