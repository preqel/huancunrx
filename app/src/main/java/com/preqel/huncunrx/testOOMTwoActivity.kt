package com.preqel.huncunrx

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by preqel on 2018/10/15.
 */
class testOOMTwoActivity: AppCompatActivity() {


    private var activity: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_scroll)

        activity = this
    }
}