package com.example.clockview


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import java.util.*
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


class ClockView : View {
    private var mHeight = 0
    private var mWidth = 0
    private var padding = 0
    private var fontSize = 0
    private val numeralSpacing = 0
    private var handTruncation = 0
    private var hourHandTruncation = 0
    private var radius = 0
    private var paint: Paint? = null
    private var isInit = false
    private val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    private val rect = Rect()

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onDraw(canvas: Canvas) {
        if (!isInit) {
            Companion.initClock(this)
        }
        canvas.drawColor(Color.WHITE)
        drawCircle(canvas)
        drawCenter(canvas)
        drawNumeral(canvas)
        drawHands(canvas)
        postInvalidateDelayed(500)
        invalidate()
    }

    private fun drawHand(canvas: Canvas, loc: Double, isHour: Boolean) {
        val angle = Math.PI * loc / 30 - Math.PI / 2
        val handRadius =
            if (isHour) radius - handTruncation - hourHandTruncation
            else radius - handTruncation
        canvas.drawLine(
            (mWidth / 2).toFloat(), (mHeight / 2).toFloat(),
            (mWidth / 2 + cos(angle) * handRadius).toFloat(),
            (mHeight / 2 + sin(angle) * handRadius).toFloat(),
            paint!!
        )
    }

    private fun drawHands(canvas: Canvas) {
        val c = Calendar.getInstance()
        var hour = c[Calendar.HOUR_OF_DAY].toFloat()
        hour = if (hour > 12) hour - 12 else hour
        drawHand(canvas, ((hour + c[Calendar.MINUTE] / 60) * 5f).toDouble(), true)
        drawHand(canvas, c[Calendar.MINUTE].toDouble(), false)
        drawHand(canvas, c[Calendar.SECOND].toDouble(), false)
    }

    private fun drawNumeral(canvas: Canvas) {
        paint!!.textSize = fontSize.toFloat()
        for (number in numbers) {
            val tmp = number.toString()
            paint!!.getTextBounds(tmp, 0, tmp.length, rect)
            val angle = Math.PI / 6 * (number - 3)
            val x = (mWidth / 2 + cos(angle) * radius - rect.width() / 2).toInt()
            val y = (mHeight / 2 + sin(angle) * radius + rect.height() / 2).toInt()
            canvas.drawText(tmp, x.toFloat(), y.toFloat(), paint!!)
        }
    }

    private fun drawCenter(canvas: Canvas) {
        paint!!.style = Paint.Style.FILL
        canvas.drawCircle((mWidth / 2).toFloat(), (mHeight / 2).toFloat(), 12f, paint!!)
    }

    private fun drawCircle(canvas: Canvas) {
        paint!!.reset()
        paint!!.color = Color.BLUE
        paint!!.strokeWidth = 5f
        paint!!.style = Paint.Style.STROKE
        paint!!.isAntiAlias = true
        canvas.drawCircle(
            (mWidth / 2).toFloat(), (mHeight / 2).toFloat(), (radius + padding - 10).toFloat(),
            paint!!
        )
    }

    companion object {
        private fun initClock(clockView: ClockView) {
            clockView.mHeight = clockView.height
            clockView.mWidth = clockView.width
            clockView.padding = clockView.numeralSpacing + 50
            clockView.fontSize = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 13f,
                clockView.resources.displayMetrics
            ).toInt()
            val min = min(clockView.mHeight, clockView.mWidth)
            clockView.radius = min / 2 - clockView.padding
            clockView.handTruncation = min / 20
            clockView.hourHandTruncation = min / 7
            clockView.paint = Paint()
            clockView.isInit = true
        }
    }
}
