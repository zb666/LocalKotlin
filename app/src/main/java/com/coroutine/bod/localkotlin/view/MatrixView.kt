package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.BitmapCompat
import com.coroutine.bod.localkotlin.R
import com.google.android.material.canvas.CanvasCompat

/**
 *
 * @ClassName: MatrixView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2019-10-05
 */
class MatrixView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val earthBitmap = BitmapFactory.decodeResource(resources,R.drawable.focus_earth)

    private val bitmapCanvas = BitmapFactory.decodeResource(resources, R.drawable.empty)


    private val options = BitmapFactory.Options()

    private var mBitmap: Bitmap =
    BitmapFactory.decodeResource(resources, R.drawable.focus_earth, options)


    private var mapCanvas:Canvas?=null

    private val mPaint = Paint().apply {
        color = Color.RED
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

    init {
        mapCanvas = Canvas(mBitmap.copy(Bitmap.Config.ARGB_8888,true))
    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }

    private var mMatrix = matrix
    //// setMirrorOne(bitmap1, matrix);
    //		// setInvertedImage(bitmap1, matrix);
    //		// setBaseChange(matrix);

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mapCanvas?.drawBitmap(earthBitmap,mMatrix,mPaint)

        canvas?.drawBitmap(mBitmap,mMatrix,mPaint)

        canvas?.drawBitmap(bitmapCanvas,mMatrix,mPaint)

    }

    private fun mirrorMatrix(){
        /**
         * matrix.setScale(-1, 1);
        matrix.postTranslate(bitmap1.getWidth(), 0);
         */
        mMatrix.setScale(1.1f,1.5f)
    }

}