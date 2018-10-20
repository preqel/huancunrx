package com.preqel.huncunrx

/**
 * Created by preqel on 2018/10/14.
 */
class Zebra(val value:String) {

    override fun equals(other: Any?): Boolean {

       // if(this == other)return true

        if(other is Zebra){
            if(value.equals(other.value))
                return true
            else
                return false
        }
        return false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}