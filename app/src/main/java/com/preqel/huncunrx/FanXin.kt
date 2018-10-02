package com.preqel.huncunrx

/**
 * Created by preqel on 2018/9/22.
 */
class FanXin{

    companion object {

        fun < T> getName(str: T) {



            var result: T
            when (str) {
                is String -> result = str
                is Int -> {
                    result = str
                }
                is Number -> {
                    result = str
                }
            }
        }

    }
}