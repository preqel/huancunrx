package com.preqel.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.widget.Scroller

/**
 * Created by preqel on 2018/10/7.
 */
class MyRecyclerView : RecyclerView {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        scroller = Scroller(context)
    }

    var vTracker: VelocityTracker? = null;

    private var scroller: Scroller? = null;

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_POINTER_UP) {
            Log.d("TAG", "preqel")
            scroller!!.startScroll(0, 10, 10, 100, 1000)
        }
        return super.onTouchEvent(event)
    }

    var oldX: Int = 0
    var oldY: Int = 0
    var lastX: Int = 0
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        var intercept = false

        //x,y值均相对于view的左上角顶点位置
        val newX = ev.getX().toInt()
        val newY = ev.getY().toInt()
        when (ev.getAction()) {
            MotionEvent.ACTION_DOWN -> {
                //不能拦截action_down事件，否则action_move/up事件不会向子元素传递
                //(这里直接给结论，原因见源码ViewGroup$dispatchTouchEvent(ev))
                Log.e("wang", "onInterceptTouchEvent_action_down")
                intercept = false
            }
            MotionEvent.ACTION_MOVE -> {
                val disX = newX - oldX
                val disY = newY - oldY
                //当触摸移动水平方向距离>竖直方向时，拦截事件
                if (Math.abs(disX) > Math.abs(disY)) {
                    Log.e("wang", "onInterceptTouchEvent_action_move")
                    intercept = true
                } else {
                    intercept = false
                }
            }
            MotionEvent.ACTION_UP -> {
                //如果拦截了up事件，那么子元素的无法正常处理up事件；但并不影响SimpleViewPager处理up事件
                //(这里直接给结论，原因见ViewGroup$dispatchTouchEvent(ev)的源码)
                Log.e("wang", "onInterceptTouchEvent_action_up")
                intercept = false
            }
            else -> {
            }
        }
        lastX = newX
        oldX = newX
        oldY = newY
        return intercept
    }

    override  fun computeScroll(){
        if (scroller!!.computeScrollOffset()) {
            val currX = scroller!!.getCurrX()
            this.scrollTo(currX, 0)
            postInvalidate()
        }
    }


}