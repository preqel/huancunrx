package com.preqel.huncunrx;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.preqel.treenode.TreeNode;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import junit.framework.Test;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {

    private String memoryCache = null;
    private String diskCache = "从硬盘读取数据";

    @BindView(R.id.tv_1)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        doCached();
        new Thread(){
            @Override
            public synchronized void start() {
                doFastSort();
                super.start();
            }
        }.start();

        mTextView.setText(getAddress());

        mTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),testOOMActivity.class);
                startActivity(intent);
            }
        });

        setText(R.string.app_name);
        testErChaShu();
        testErfenSearch();
        TestInner testInner = new TestInner();
        TestInner.InnerClass innerClass = testInner.getInstance();


    }

    private void testErfenSearch() {
        int[] arra = new int[]{5, 1, 10, 23, 34, 2};
        int result = SearchUtil.binarySearch(arra, 6, 23);
        Log.d("TAG", "preqel testErfenSearch:" + result);
    }

    private void testErChaShu() {

        Object[] objs = new Object[]{5, 2, 12, 11, 1};
        TreeNode treeNode = new TreeNode();
        treeNode.createTree(objs
        );
    }

    @android.support.annotation.NonNull
    private String getAddress() {
        String str = null;
        return str;
    }

    public void setText(@StringRes int id){
        mTextView.setText(id);
    }
    @UiThread
    private void doFastSort() {
       Log.d("TAG", Thread.currentThread().getId()+"id");
        FastSort fastSort = new FastSort();
        fastSort.doFastSort();
        fastSort.pirntResult();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("adb","123");
        Log.d("TAG",  "preqel"+ FastGet.Companion.getInstances().getStr());
        FastSingle.Companion.getInstance();

      //  FastGet.Companion.getInstances().getStr();
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

    Disposable mDisposable = Flowable.interval( 1, TimeUnit.SECONDS).doOnNext(new Consumer<Long>() {
        @Override
        public void accept(Long aLong) throws Exception {

        }
    }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
        @Override
        public void accept(Long aLong) throws Exception {
            Log.d("TAG","设置文本"+ aLong);
        }
    });




}
