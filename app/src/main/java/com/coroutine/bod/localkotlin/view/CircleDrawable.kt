package com.coroutine.bod.localkotlin.view

import android.graphics.*
import android.graphics.drawable.Drawable
import kotlin.math.min

/**
 *
 * @ClassName: CircleDrawable
 * @Description: 自定义圆角Drawable
 * @Author: zb666
 * @CreateDate: 2020-01-11
 */
class CircleDrawable(bitmap: Bitmap) : Drawable() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        isDither = true
        strokeWidth = 0f
    }

    private var mBitmap: Bitmap = bitmap

    private var mWidth: Int = 0

    init {
        val bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = bitmapShader
        paint.isAntiAlias = true
        mWidth = min(mBitmap.width, mBitmap.height)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun setBounds(bounds: Rect) {
        super.setBounds(bounds)
    }

    override fun getIntrinsicWidth(): Int = mWidth

    override fun getIntrinsicHeight(): Int = mWidth

    override fun draw(canvas: Canvas) {
        canvas.drawCircle(mWidth * 0.5f, mWidth * 0.5f, mWidth * 0.4f, paint)
    }
}