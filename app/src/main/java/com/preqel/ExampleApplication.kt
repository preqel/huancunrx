package com.preqel

import android.app.Application
import android.util.Log
import com.squareup.leakcanary.LeakCanary

/**
 * Created by preqel on 2018/10/15.
 */
class ExampleApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG","Application exeuted")
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}