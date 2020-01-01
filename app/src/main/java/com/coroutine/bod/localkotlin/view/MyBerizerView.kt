package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import timber.log.Timber

/**
 *
 * @ClassName: MyBerizerView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-04
 */
class MyBerizerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPath = Path()
    private val mLinePath = Path()
    private val mQuadPath = Path()

    private val mCubicPath = Path()

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            color = Color.RED
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }

    private val mLinePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            color = Color.BLUE
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }

    private val mCubicPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            color = Color.GREEN
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }

    private var mPointX = 0f
    private var mPointY = 0f

    private var mEndX = 0f

    private var mEndY = 0f

    private var mStartX = 0f
    private var mStartY = 0f


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mPointX = (w / 4).toFloat()
        mPointY = (h / 2).toFloat()

        mEndX = w.toFloat()
        mEndY = h.toFloat()

        Timber.d("onSizeChanged(): $w $h")

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_MOVE -> {
                mPointX = event.x
                mPointY = event.y
                invalidate()
            }
        }
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mLinePath.reset()
        mPath.reset()
        mQuadPath.reset()

        mPath.moveTo(0f, height.toFloat())
        mPath.quadTo(mPointX, mPointY, (width / 2).toFloat(), height.toFloat())

        mLinePath.moveTo(0f, height.toFloat())
        mLinePath.lineTo(mPointX, mPointY)
        mLinePath.lineTo((width / 2).toFloat(), height.toFloat())
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawPath(mLinePath, mLinePaint)

        mCubicPath.moveTo(0f, (height/2).toFloat()+height/6)
        mCubicPath.cubicTo(
            (width/4).toFloat(), (height/4).toFloat(),
            (width*3/8).toFloat(), (height).toFloat(),
            (width/2).toFloat(), (height/2).toFloat()
        )
        canvas?.drawPath(mCubicPath, mCubicPaint)


    }
}

