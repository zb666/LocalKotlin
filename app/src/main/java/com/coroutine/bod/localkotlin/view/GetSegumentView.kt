package com.coroutine.bod.localkotlin.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 *
 * @ClassName: GetSegumentView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-05-26
 */
class GetSegumentView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mPaint: Paint
    private var mDstPath: Path
    private var mCirclePath: Path
    private var mPathMeasureView: PathMeasure
    private var mCurValue = 0f

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
            .apply {
                style = Paint.Style.STROKE
                strokeWidth = 4.0f
                color = Color.BLACK
                mDstPath = Path()
                mCirclePath = Path().apply {
                    addCircle(100f, 100f, 50f, Path.Direction.CW)
                }
            }
        mPathMeasureView = PathMeasure(mCirclePath, true)
        ValueAnimator.ofFloat(0f, 1.0f)
            .apply {
                duration = 3_000
                repeatCount = ValueAnimator.INFINITE
                addUpdateListener {
                    mCurValue = it.animatedValue as? Float?:0f
                    invalidate()
                }
            }.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.WHITE)
        val stopValue = mPathMeasureView.length * mCurValue
        mDstPath.reset()
        mPathMeasureView.getSegment(0f,stopValue,mDstPath,true)
        canvas?.drawPath(mDstPath,mPaint)
    }


}