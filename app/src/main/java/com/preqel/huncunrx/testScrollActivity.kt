package com.preqel.huncunrx

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.VelocityTracker
import android.widget.Scroller
import com.preqel.adapter.MyAdapter

/**
 * wk
 */
class testScrollActivity: AppCompatActivity() {

    var velocitytracker: VelocityTracker? = null;
    var recyclerview: RecyclerView? = null
    private var scroller: Scroller? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_scroll)
        velocitytracker = VelocityTracker.obtain()
        this.scroller =Scroller(this)
        this.recyclerview = findViewById(R.id.recyclerview)
        this.recyclerview?.layoutManager = LinearLayoutManager(this)
        var list = arrayOf("123", "123","1231","3433","23213","232","3453","12121","232")
        recyclerview?.adapter = MyAdapter(this, list)
    }
//
//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        if(event?.action == MotionEvent.ACTION_MOVE){
//            velocitytracker?.addMovement(event)
//            velocitytracker?.computeCurrentVelocity(1000)
//            val xVeloctiy: Float = velocitytracker?.getXVelocity()!!.toFloat()
//            Log.e("wang", "xVelocity:" +xVeloctiy);
//        }else if(event?.action == MotionEvent.ACTION_UP){
//
//
//        }
//        return super.onTouchEvent(event)
//    }

}