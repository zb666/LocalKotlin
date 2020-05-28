package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.lang.Exception

/**
 *
 * @ClassName: CarSurfaceView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-09
 */
class CarSurfaceView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr), SurfaceHolder.Callback, Runnable {

    private var isDrawing = false

    var aX: Float = 0f
    var aY: Float = 400f

    private val mPath = Path()

    private val mPaint = Paint()

    init {
        holder.addCallback(this)
        isFocusableInTouchMode = true
        keepScreenOn = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            focusable = FOCUSABLE
        }
        mPath.moveTo(x, y)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        isDrawing = false
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        isDrawing = true
        Thread(this).start()
    }

    override fun run() {
        while (isDrawing) {
            startDraw()
            x += 1
            y = ((100 * Math.sin(x * 2 * Math.PI / 180) + 400).toFloat())
            mPath.lineTo(x, y)
        }
    }

    private fun startDraw() {
        var canvas: Canvas? = null
        try {
            canvas = holder.lockCanvas().apply {
                drawColor(Color.WHITE)
                drawPath(mPath, mPaint)
            }
        } catch (t: Exception) {
            t.printStackTrace()
        } finally {
            canvas?.run {
                holder.unlockCanvasAndPost(this)
            }
        }
    }


}