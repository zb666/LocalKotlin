package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import timber.log.Timber

/**
 *
 * @ClassName: PathMeasureView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-04
 */
class PathMeasureView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mPaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
            .apply {
                color = Color.RED
                strokeWidth = 5f
                style = Paint.Style.STROKE
            }
    }

    private val mPath = Path().apply {

    }

    private val pos = FloatArray(2)
    private val tan = FloatArray(2)

    private val mCirclePath = Path()

    private val mDstPath = Path()

    private val myPathMeasureView = PathMeasure()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPath.reset()
        mPath.addRect(100f,100f,500f,500f,Path.Direction.CW)
        mPath.addCircle(250f,250f,100f,Path.Direction.CW)
        canvas?.drawPath(mPath,mPaint)

        pathMeasureView.setPath(mPath,false)

        log("pathMeasureView: ${pathMeasureView.length}")

        val length = pathMeasureView.length
        pathMeasureView.getPosTan(length,pos,tan)

        log("\n ${pos[0]} \n ${pos[1]} \n ${tan[0]} \n ${tan[1]}")

        pathMeasureView.getSegment(0f,600f,dstPath,true) //是否从起点开始绘制
        canvas?.drawPath(dstPath,mPaint)
//        mPath.addCircle(0f, 0f, 200f, Path.Direction.CW)
//
//        mPath.lineTo(100f,500f)
//
//        log(pathMeasureView.length.toString())
//
//        //关联创建好的path,
//        pathMeasureView.setPath(mPath, true)
//        canvas?.drawPath(mPath, mPaint)
//        canvas?.drawRect(100f, 100f, 400f, 400f, mPaint)
//
//        pathMeasureView.getSegment(100f,1000f,dstPath,false)
//
//        log("dstpath: $dstPath")
//
//        canvas?.drawPath(dstPath,mPaint)

        //math.atan2(tan[1], tan[0])*180.0 / math.P


        mCirclePath.addCircle(200f,200f,100f,Path.Direction.CW)


        canvas?.drawPath(mCirclePath,mPaint)

        pathMeasureView.setPath(mCirclePath,false)

        val pathLength = pathMeasureView.length
        pathMeasureView.getPosTan(pathLength /4,pos,tan)

        Timber.d("MyPosTan:${pos[0]} ${pos[1]} ${tan[0]} ${tan[1]}")

        //float degree = (float) (Math.atan2(mTan[1], mTan[0]) * 180 / Math.PI);

        val degress = Math.atan2(tan[1].toDouble(), tan[0].toDouble())*180/Math.PI

        canvas?.save()
        canvas?.rotate(degress.toFloat())
        canvas?.restore()

        Timber.d("Degress:$degress")

    }

    fun log(logInfo: String) {
        Timber.d("PathMeasure: $logInfo")
    }

    private val pathMeasureView = PathMeasure()


    private val dstPath = Path()
//    private val mMatrix = Matrix()
//    private val pos = FloatArray(2)
//    private val tan = FloatArray(2)
//    private val mPath = Path()
//    private val mFloat: Float = 0.toFloat()
}