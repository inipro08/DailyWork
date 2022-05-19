package com.inis.dailywork.widget.timelineview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import com.inis.dailywork.R


/**
 * View used to display Timeline. It is possible to put different line and marker sizes and colors,
 * text inside markers, vertical and horizontal orientations.
 */
class TimelineView(context: Context?, attrs: AttributeSet) :
    View(context, attrs) {
    private var marker: Paint? = null
    private var markerActive: Paint? = null
    private var markerTextPaint: Paint? = null
    private var startLine: Paint? = null
    private var endLine: Paint? = null
    private var drawable: Drawable? = null
    private var markerSize = 0
    private var markerText: String? = null
    private var lineOrientation = 0
    private var active = false
    private fun init(attrs: AttributeSet) {
        val typedArray = context
            .obtainStyledAttributes(attrs, R.styleable.TimelineView)
        markerSize = typedArray.getDimensionPixelSize(R.styleable.TimelineView_markerSize, 25)
        lineOrientation = typedArray.getInt(R.styleable.TimelineView_lineOrientation, 1)
        active = typedArray.getBoolean(R.styleable.TimelineView_markerActive, false)
        val lineSize = typedArray.getDimensionPixelSize(R.styleable.TimelineView_lineSize, 4)
        val markerStrokeWidth = typedArray
            .getDimensionPixelSize(R.styleable.TimelineView_markerStrokeWidth, 1)
        val markerColor = typedArray.getColor(R.styleable.TimelineView_markerColor, Color.BLACK)
        val markerActiveColor = typedArray
            .getColor(R.styleable.TimelineView_markerActiveColor, Color.BLACK)
        val markerActiveStrokeWidth = typedArray
            .getDimensionPixelSize(R.styleable.TimelineView_markerActiveStrokeWidth, 0)
        val startLineColor = typedArray.getColor(R.styleable.TimelineView_lineColor, Color.BLACK)
        val endLineColor = typedArray.getColor(R.styleable.TimelineView_lineColor, Color.BLACK)
        val textSize = typedArray
            .getDimensionPixelSize(R.styleable.TimelineView_markerTextSize, markerSize / 2)
        val textColor = typedArray.getColor(R.styleable.TimelineView_markerTextColor, Color.WHITE)
        marker = Paint()
        marker!!.style = Paint.Style.FILL
        marker!!.isAntiAlias = true
        marker!!.color = markerColor
        marker!!.strokeWidth = markerStrokeWidth.toFloat()
        markerTextPaint = Paint()
        markerTextPaint!!.color = textColor
        markerTextPaint!!.style = Paint.Style.FILL
        markerTextPaint!!.textAlign = Paint.Align.CENTER
        markerTextPaint!!.isAntiAlias = true
        markerTextPaint!!.textSize = textSize.toFloat()
        markerActive = Paint()
        markerActive!!.style = Paint.Style.STROKE
        markerActive!!.isAntiAlias = true
        markerActive!!.color = markerActiveColor
        markerActive!!.strokeWidth = markerActiveStrokeWidth.toFloat()
        startLine = Paint()
        startLine!!.style = Paint.Style.FILL
        startLine!!.isAntiAlias = true
        startLine!!.color = startLineColor
        startLine!!.strokeWidth = lineSize.toFloat()
        endLine = Paint()
        endLine!!.style = Paint.Style.FILL
        endLine!!.isAntiAlias = true
        endLine!!.color = endLineColor
        endLine!!.strokeWidth = lineSize.toFloat()
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //Width measurements of the width and height and the inside view of child controls
        val w = (markerSize + paddingLeft + paddingRight + marker!!.strokeWidth
                + markerActive!!.strokeWidth).toInt()
        val h = (markerSize + paddingTop + paddingBottom + marker!!.strokeWidth
                + markerActive!!.strokeWidth).toInt()

        // Width and height to determine the final view through a systematic approach to decision-making
        val widthSize = resolveSizeAndState(w, widthMeasureSpec, 0)
        val heightSize = resolveSizeAndState(h, heightMeasureSpec, 0)
        setMeasuredDimension(widthSize, heightSize)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val hCenter = width / 2
        val vCenter = height / 2

        // Horizontal line
        if (lineOrientation == 0) {
            canvas.drawLine(
                0f, vCenter.toFloat(), (hCenter - markerSize / 2).toFloat(), vCenter.toFloat(),
                startLine!!
            )
            canvas.drawLine(
                (hCenter + markerSize / 2).toFloat(),
                vCenter.toFloat(),
                width.toFloat(),
                vCenter.toFloat(),
                endLine!!
            )
        } else {
            // Vertical line
            canvas.drawLine(
                hCenter.toFloat(), 0f, hCenter.toFloat(), (vCenter - markerSize / 2).toFloat(),
                startLine!!
            )
            canvas.drawLine(
                hCenter.toFloat(),
                (vCenter + markerSize / 2).toFloat(),
                hCenter.toFloat(),
                height.toFloat(),
                endLine!!
            )
        }

        // Marker
        if (marker!!.style == Paint.Style.FILL) {
            canvas.drawCircle(
                hCenter.toFloat(), vCenter.toFloat(), (markerSize / 2).toFloat(),
                marker!!
            )
        } else {
            canvas.drawCircle(
                hCenter.toFloat(), vCenter.toFloat(), markerSize / 2 - marker!!.strokeWidth / 2,
                marker!!
            )
        }

        // Text inside marker
        if (drawable != null) {
            // Drawable inside marker
            drawable!!.setBounds(
                hCenter - markerSize / 2, vCenter - markerSize / 2,
                hCenter + markerSize / 2, vCenter + markerSize / 2
            )
            drawable!!.draw(canvas)
        } else if (markerText != null && !markerText!!.isEmpty() && markerTextPaint != null) {
            canvas.drawText(
                markerText!!, hCenter.toFloat(), vCenter + markerTextPaint!!.textSize / 3,
                markerTextPaint!!
            )
        }

        // Active marker
        if (active) {
            canvas.drawCircle(
                hCenter.toFloat(), vCenter.toFloat(), (markerSize / 2).toFloat(),
                markerActive!!
            )
        }
    }

    /*------------------
   Getters and setters
    -------------------*/
    var markerColor: Int
        get() = marker!!.color
        set(color) {
            marker!!.color = color
            invalidate()
        }

    fun setMarkerSize(markerSize: Int) {
        this.markerSize = markerSize
        invalidate()
    }

    fun getMarkerSize(): Int {
        return markerSize
    }

    val markerStrokeWidth: Float
        get() = marker!!.strokeWidth

    fun setMarkerStrokeWidth(width: Int) {
        marker!!.strokeWidth = width.toFloat()
        invalidate()
    }

    fun setFillMarker(fill: Boolean) {
        if (fill) {
            marker!!.style = Paint.Style.FILL
        } else {
            marker!!.style = Paint.Style.STROKE
        }
        invalidate()
    }

    var markerActiveColor: Int
        get() = markerActive!!.color
        set(color) {
            markerActive!!.color = color
            invalidate()
        }
    val markerActiveStrokeWidth: Float
        get() = markerActive!!.strokeWidth

    fun setMarkerActiveStrokeWidth(width: Int) {
        markerActive!!.strokeWidth = width.toFloat()
        invalidate()
    }

    var startLineColor: Int
        get() = startLine!!.color
        set(color) {
            startLine!!.color = color
            invalidate()
        }
    var endLineColor: Int
        get() = endLine!!.color
        set(color) {
            endLine!!.color = color
            invalidate()
        }

    fun isActive(): Boolean {
        return active
    }

    fun setActive(active: Boolean) {
        this.active = active
        invalidate()
    }

    val lineSize: Float
        get() = startLine!!.strokeWidth

    fun setLineSize(lineSize: Int) {
        startLine!!.strokeWidth = lineSize.toFloat()
        endLine!!.strokeWidth = lineSize.toFloat()
        invalidate()
    }

    var textColor: Int
        get() = markerTextPaint!!.color
        set(color) {
            markerTextPaint!!.color = color
            invalidate()
        }
    val textSize: Float
        get() = markerTextPaint!!.textSize

    fun setTextSize(textSize: Int) {
        markerTextPaint!!.textSize = textSize.toFloat()
        invalidate()
    }

    var text: String?
        get() = markerText
        set(text) {
            markerText = text
            invalidate()
        }

    fun setNumber(number: Int) {
        markerText = number.toString()
        invalidate()
    }

    fun setDrawable(drawable: Drawable?) {
        this.drawable = drawable
        invalidate()
    }

    fun setLineType(lineType: LineType?) {
        when (lineType) {
            LineType.BEGIN -> {
                startLine!!.alpha = 0
                endLine!!.alpha = 255
            }
            LineType.END -> {
                startLine!!.alpha = 255
                endLine!!.alpha = 0
            }
            LineType.ONLYONE -> {
                startLine!!.alpha = 0
                endLine!!.alpha = 0
            }
            LineType.NORMAL -> {
                startLine!!.alpha = 255
                endLine!!.alpha = 255
            }
        }
        invalidate()
    }

    init {
        if (!isInEditMode) {
            init(attrs)
        }
    }
}