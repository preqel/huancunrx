package com.preqel.huncunrx

/**
 * Created by preqel on 2018/9/22.
 */
class TestDelegrateTwo{


    interface Base{
        fun print()
    }

    class BaseImpl(val x:Int ):Base{
        override fun print(){
            print(x)
        }
    }

    class Derived(b:Base):Base by b;


}

