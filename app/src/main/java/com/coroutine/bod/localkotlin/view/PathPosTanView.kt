package com.coroutine.bod.localkotlin.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import timber.log.Timber
import kotlin.math.atan2
import android.graphics.BitmapFactory
import android.graphics.PathMeasure
import com.coroutine.bod.localkotlin.R


/**
 * @ClassName: PathPosTanView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-04
 */
class PathPosTanView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mPath: Path? = null

    //当前圆上的位置
    private var mPos = FloatArray(2)
    //当前运动轨迹的切线值
    private var mTan = FloatArray(2)

    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            color = Color.RED
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }

    private var mBlackPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            color = Color.BLACK
            strokeWidth = 2f
            style = Paint.Style.STROKE
        }

    private var mPathMeasure = PathMeasure()

    private val options = BitmapFactory.Options()

    private var mBitmap: Bitmap =
        BitmapFactory.decodeResource(resources, R.drawable.btn_back, options)

    init {
        mPath = Path()
            .apply {
                addCircle(200f, 200f, 100f, Path.Direction.CW)
            }

        //缩小图片

        options.inSampleSize = 4


        mPathMeasure.setPath(mPath, false)
    }

    private var mCurValue = 0f

    fun startRotate() {
        ValueAnimator.ofFloat(1f, 0f)
            .apply {
                repeatCount = ValueAnimator.INFINITE
                duration = 1500
                interpolator = LinearInterpolator()
                addUpdateListener {
                    mCurValue = it.animatedValue as Float
                    invalidate()
                }
            }.start()

        listOf("").forEachIndexed { index, s ->

        }

        listOf("").indices
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val distance = mPathMeasure.length * mCurValue

        mPathMeasure.getPosTan(distance, mPos, mTan)

        canvas.drawCircle(mPos[0], mPos[1], 10f, mBlackPaint)

        canvas.drawPath(mPath!!, mPaint)
        val degress = atan2(mTan[1].toDouble(), mTan[0].toDouble()) * 180 / Math.PI

        canvas.save()
        canvas.translate(400f, 400f)

        canvas.rotate(degress.toFloat())

        canvas.drawLine(0f, -200f, 100f, -200f, mPaint)

        canvas.restore()

        /**
         *  PathMeasure pathMeasure = new PathMeasure(mPath, false);
        //将pos信息和tan信息保存在mMatrix中
        pathMeasure.getMatrix(pathMeasure.getLength() * mFloat, mMatrix,
        PathMeasure.POSITION_MATRIX_FLAG | PathMeasure.TANGENT_MATRIX_FLAG);
         */

      //将pos信息和tan信息保存在mMatrix中
        mPathMeasure.getMatrix(
            distance,
            mMatrix,
            PathMeasure.POSITION_MATRIX_FLAG or PathMeasure.TANGENT_MATRIX_FLAG
        )

        //将pos信息和tan信息保存在mMatrix中
        mMatrix.preTranslate(-(mBitmap.width / 2).toFloat(), -(mBitmap.height / 2).toFloat())

        //canvas.drawBitmap(mBitmap,mMatrix, mPaint);
        canvas.drawBitmap(mBitmap,mMatrix,mPaint)

    }


    private var mMatrix = Matrix()
}
