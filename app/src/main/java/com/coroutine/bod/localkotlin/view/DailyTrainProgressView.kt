package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.text.Layout
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import android.text.StaticLayout
import android.text.TextPaint
import android.text.TextUtils
import androidx.annotation.IntRange
import com.coroutine.bod.localkotlin.R


/**
 *
 * @ClassName: DailyTrainProgressView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-12-26
 */
class DailyTrainProgressView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val outPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
                .apply {
                    strokeWidth = height * 0.1f
                    style = Paint.Style.STROKE
                    color = Color.WHITE
                }
    }

    private val innerPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
                .apply {
                    style = Paint.Style.FILL
                    strokeWidth = height * 0.05f
                    color = ContextCompat.getColor(context, R.color.colorPrimaryGreen)
                }
    }

    private val progressPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
                .apply {
                    style = Paint.Style.FILL
                    strokeWidth = height * 0.05f
                    color = ContextCompat.getColor(context, R.color.colorDeepGreen)
                }
    }

    private val textPaint by lazy {
        TextPaint(Paint.ANTI_ALIAS_FLAG)
                .apply {
                    textSize = 24f
                    color = ContextCompat.getColor(context, R.color.focusWhiteColor)
                }
    }

    private var textInfo = "训练计划%d/4"

    private var textFinish = "完成训练%d/4"

    private var staticPaint: StaticLayout? = null

    private var centerStr = ""

    private var sweepAngle = 90f

    fun setProgress(@IntRange(from = 0,to = 4)progress: Int) {
        when (progress) {
            0, 1, 2, 3 -> {
                centerStr = String.format(textInfo, progress)
                innerPaint.color = ContextCompat.getColor(context, R.color.colorPrimaryGreen)
                textPaint.color = ContextCompat.getColor(context, R.color.focusWhiteColor)
                progressPaint.color = ContextCompat.getColor(context, R.color.colorDeepGreen)
            }
            4 -> {
                centerStr = String.format(textFinish, progress)
                innerPaint.color = ContextCompat.getColor(context, R.color.focusWhiteColor)
                textPaint.color = ContextCompat.getColor(context, R.color.colorDeepGreen)
                progressPaint.color = ContextCompat.getColor(context, R.color.colorDeepGreen)
            }
        }
        staticPaint = StaticLayout(centerStr, textPaint, 48, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true)
        sweepAngle *= progress
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val parentWidth = width
        val parentHeight = height
//        textPaint.getTextBounds(textInfo, 0, textInfo.length, rect)
        canvas?.run {
            drawCircle(width * 0.5f, height * 0.5f, width * 0.45f, outPaint)
            drawArc(0f, 0f, width.toFloat(), height.toFloat(), -90f, sweepAngle, true, progressPaint)
            drawCircle(width * 0.5f, height * 0.5f, width * 0.425f, innerPaint)
            canvas.save()
            staticPaint?.run {
                canvas.translate(parentWidth * 0.5f - (this.width * 0.5f), (parentHeight * 0.5f - this.height * 0.5f))
                draw(canvas)
            }
            canvas.restore()
        }
    }

}