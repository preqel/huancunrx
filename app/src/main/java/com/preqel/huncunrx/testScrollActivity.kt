package com.preqel.huncunrx

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
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
       val sum = {x:Int,y:Int -> x+y}

        var sum2 = cacl(20, 30) { m, n ->
            m + n
        }
        Log.d("TAG","lambda"+sum2)

        var  a = 10
        {
            println(a)
        }()

    }
    fun cacl(x:Int,y:Int,less:(z1:Int,z2:Int)->Int){
        val c   = x+less(3,4)
        Log.d("TAG","preqel2:" + c  )
     }

    fun max(x:Int,less:(Int,Int)->Int):Int{
        return x+less(x,x)
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