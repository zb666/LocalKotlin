package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.Rect
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

/**
 *
 * @ClassName: DoubleBufferView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-21
 */
class DoubleBufferView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr) {

    private var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 5f
        color = Color.BLUE
        textSize = 50f
    }

    init {
        holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(
                holder: SurfaceHolder?,
                format: Int,
                width: Int,
                height: Int
            ) {

            }

            override fun surfaceDestroyed(holder: SurfaceHolder?) {

            }

            override fun surfaceCreated(holder: SurfaceHolder?) {
                drawText(holder)
            }

        })
    }

    private fun drawText(holder: SurfaceHolder?) {
        Thread(Runnable {
//            clearView(holder)
            for (index in 1..10) {
                val lockCanvas = holder?.lockCanvas()
                val strDraw = "index$index"
                val measuredText = mPaint.measureText(strDraw)
                lockCanvas?.drawText("index:$index", 50f, 50f*index, mPaint)
                lockCanvas?.run {
                    holder.unlockCanvasAndPost(this)
                }
                Thread.sleep(1_000)
            }
//            holder?.lockCanvas(Rect(10,10,300,200))?.run {
//                drawColor(Color.BLUE)
//                holder.unlockCanvasAndPost(this)
//            }

        }).start()
    }

    private fun clearView(holder: SurfaceHolder?) {
        holder?.lockCanvas()?.run {
//            drawColor(Color.TRANSPARENT,PorterDuff.Mode.CLEAR)
        }
    }

}