package com.preqel.huncunrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {

    private String memoryCache = null;
    private String diskCache = "从硬盘读取数据";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doCached();
    }



    final Observable<String> memory =  Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> e) throws Exception {

            if(memoryCache!= null){
                e.onNext(memoryCache);
            }else{
                e.onComplete();
            }
        }
    });


    final Observable<String> disk = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> e) throws Exception {


            if(diskCache != null){
                e.onNext(diskCache);
            }else{
                e.onComplete();
            }
        }
    });

    final   Observable<String> netwok = Observable.just( "从网络获取数据");

    public void doCached(){
        Observable.concat(memory,disk,netwok).firstElement().subscribe(new Consumer<String>(){

            @Override
            public void accept(String s) throws Exception {

                Log.d("TAG","最终获取的数据来源"+s);
            }
        });
    }
}
