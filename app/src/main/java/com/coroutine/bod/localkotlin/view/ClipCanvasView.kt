package com.coroutine.bod.localkotlin.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withClip
import androidx.core.graphics.withTranslation
import com.coroutine.bod.localkotlin.R

/**
 *
 * @ClassName: ClipCanvasView
 * @Description:
 * @Author: zb666
 * @CreateDate: 2020-01-04
 */
class ClipCanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE,null)
    }
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
    }


    val path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.apply {
            drawColor(Color.GRAY)
            restore()
            withClip(path.apply {
                addRect(RectF(0f,0f,width.toFloat(),height*0.8f),Path.Direction.CW)
            }){
                drawRect(0f,0f,width.toFloat(),height.toFloat(),paint.apply {
                    color = Color.GREEN
                })
            }

            withClip(path.apply {
                reset()
                addCircle(width.toFloat()*0.5f,width.toFloat()*0.5f,width.toFloat()*0.35f,Path.Direction.CW)
//                addRect(RectF(0f,0f,width.toFloat(),height*0.6f),Path.Direction.CW)
            }){
                drawRect(0f,0f,width.toFloat(),height.toFloat(),paint.apply {
                    color = Color.RED
                })
            }

            withClip(path.apply {
                reset()
                addRect(RectF(0f,height*0.4f,width.toFloat(),height*0.9f),Path.Direction.CW)
            }){
                drawRect(0f,0f,width.toFloat(),height.toFloat(),paint.apply {
                    color = Color.GRAY
                })
            }


        }

    }

}
