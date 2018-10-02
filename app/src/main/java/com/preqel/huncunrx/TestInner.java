package com.preqel.huncunrx;

import android.util.Log;

/**
 * Created by preqel on 2018/9/27.
 */

public class TestInner
{




    private String str;

    public class InnerClass {

        public void display() {
            str = "dfdf";
            Log.d("TAG", "inner class " + str);

        }

    }



    public InnerClass getInstance(){
        return new InnerClass();
    }
}
