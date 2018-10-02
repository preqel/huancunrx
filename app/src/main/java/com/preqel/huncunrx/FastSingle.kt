package com.preqel.huncunrx

/**
 * Created by preqel on 2018/9/19.
 */
class FastSingle{


    companion object {

        @Volatile
        private var INSTANCE  :FastSingle? = null


        val instance:FastSingle
        get() {
            if(INSTANCE== null){
                synchronized(
                        FastSingle::class.java){
                    if(INSTANCE == null){
                        INSTANCE = FastSingle()
                    }
                }
            }
            return INSTANCE!!

        }


    }
}