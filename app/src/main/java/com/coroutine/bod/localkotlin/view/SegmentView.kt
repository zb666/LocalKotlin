package com.coroutine.bod.localkotlin.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import timber.log.Timber
import kotlin.math.abs


/**
 *
 * @ClassName: SegmentView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-04
 */
class SegmentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mPaint = Paint().apply {
        color = Color.RED
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

    private val mPath = Path().apply {
        addCircle(200f, 200f, 100f, Path.Direction.CW)
    }

    private val pathMeasureView = PathMeasure()
        .apply {
            setPath(mPath, false)
        }

    private val mDstPath = Path()

    private var mAnimatorValue: Float = 0f

    val pathLength = pathMeasureView.length

    fun startCircle() {
        ValueAnimator.ofFloat(0f, 1f)
            .apply {
                repeatCount = ValueAnimator.INFINITE
                duration = 5000
                addUpdateListener {
                    mAnimatorValue = it.animatedValue as Float
                    invalidate()
                }
            }
            .start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mDstPath.reset()
        mDstPath.lineTo(0f, 0f)

        val stopX = pathLength*mAnimatorValue

        var startX = 0f
        if (mAnimatorValue < 0.5f) {
            startX = 0f
        } else {
            startX = stopX-((0.5 - abs(mAnimatorValue - 0.5f)) * pathLength).toFloat()
        }
//        val stopX = pathLength*mAnimatorValue
//        val startX = stopX - ((0.5- abs(mAnimatorValue-0.5)))*pathLength

        pathMeasureView.getSegment(startX,stopX, mDstPath, true)

        Timber.d("DIFF RESUYLT: ${stopX - startX}")
        canvas?.drawPath(mDstPath, mPaint)

    }

}