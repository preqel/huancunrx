package com.preqel.huncunrx

import android.util.Log

/**
 * Created by preqel on 2018/9/19.
 */
class FastGet{

    companion object {

        @Volatile
        private var INSTANCE:FastGet ?= null

        val instances: FastGet
            get() {
                if (INSTANCE == null) {
                    synchronized(FastGet::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = FastGet()
                        }
                    }
                }
                return INSTANCE!!
            }
    }

    public fun getStr():String{

        for (i in 4 downTo 1 step 2 ){
            Log.d("TAg","currentStep "+ i)
        }
        val b = arrayOf(1,2,3)

        val c = "hellow world"
        for(d in c){
            Log.d("TAG","preqel"+ d)
        }

        val  a = Array(3,{ i-> i*2})
        val resutl = "the rreuslt is $c ${c.length}"
 

        return resutl
    }



}