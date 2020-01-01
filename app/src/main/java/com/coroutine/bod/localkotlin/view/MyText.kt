package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import android.view.View.MeasureSpec.*
import android.view.ViewGroup
import android.widget.TextView
import timber.log.Timber

/**
 *
 * @ClassName: MyText
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-12-23
 */
class MyText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //自己测得的
        val width = measuredWidth
        val height = measuredHeight

        Timber.d("MeasuredSize: $width   $height")

        //取出父控件的限制 可以为3中状态
        val widthMode = getMode(widthMeasureSpec)
        val widthSize = getSize(widthMeasureSpec)

        val heightMode = getMode(heightMeasureSpec)
        val heightSize = getSize(heightMeasureSpec)

        val modeResult = widthMode.intModel()
        val intModel = heightMode.intModel()

        val resoWidth = if (widthMode == AT_MOST) 50 else resolveSize(width, widthMeasureSpec)

        val resoHeight = resolveSize(height, heightMeasureSpec)

        Timber.d("MyText: mode:$intModel $modeResult $width $height $widthMode $widthSize $resoWidth $resoHeight")

        setMeasuredDimension(resoWidth,resoHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        setBackgroundResource(android.R.color.black)
    }

    fun Int.intModel():String{
        return when (this) {
            UNSPECIFIED -> {
                "UNSPECIFIED"
            }
            EXACTLY -> {
                "EXACTLY"
            }
            AT_MOST -> {
                "AT_MOST"
            }
            else->"other"
        }
    }


}