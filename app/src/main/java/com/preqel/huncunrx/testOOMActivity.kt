package com.preqel.huncunrx

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.VelocityTracker
import android.widget.Scroller
import android.widget.TextView
import com.preqel.adapter.MyAdapter
import com.preqel.leakcanary.XXXHelper
import com.trello.rxlifecycle.ActivityEvent
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * wk
 */
class testOOMActivity: AppCompatActivity() {

    var mhandler:Handler ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_scroll)
        Log.d("TAG","testOOMActivity OnCreate")
        initDate()
    }

    private fun initDate(){
//        Observable.interval(1,TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe( object: Observer<Long>{
//                    override fun onComplete() {
//                    }
//
//                    override fun onSubscribe(d: Disposable) {
//                    }
//
//                    override fun onNext(t: Long) {
//                        Log.i("接收数据", t.toString());
//                    }
//
//                    override fun onError(e: Throwable) {
//                    }
//
//                })

//        Handler().postDelayed(object:Runnable{
//            override fun run() {
//            }
//
//        },1000000)

        val m:HashMap<Int,String>  =HashMap<Int,String> ()
        val textview: TextView = findViewById(R.id.textview1);
        XXXHelper.getIntance(this).setRetainedTextView(textview)

        mhandler = object:Handler(){
           override fun handleMessage(msg: Message?) {
               if(msg!!.what== 1){
                   Log.d("TAG","hellow ")
               }
               super.handleMessage(msg)
           }
       }

        val message: Message? = mhandler?.obtainMessage(1)
        mhandler?.sendMessageDelayed(message, 10 * 60 * 1000)

    }

}