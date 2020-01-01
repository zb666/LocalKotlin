package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import timber.log.Timber

/**
 *
 * @ClassName: MyView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-02
 */
class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
        logLife("onFinishInflate")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        logLife("onAttachedToWindow")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        logLife("onMeasure $widthMode  $widthSize   $heightSize    $heightMode")
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        logLife("onLayout $l $t  $r   $b")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        logLife("onSizeChanged $w   $h     $oldw      $oldh")
    }

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 10f
        color = Color.RED
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        logLife("onDraw")
        canvas?.drawText("1",10f,50f,mPaint)

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        logLife("onDetachedFromWindow")
    }

    fun logLife(methodName:String){
        Timber.d("ViewLife: $methodName")
    }
}