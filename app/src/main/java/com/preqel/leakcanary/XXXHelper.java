package com.preqel.leakcanary;

import android.content.Context;
import android.widget.TextView;

import com.preqel.huncunrx.R;

/**
 * Created by preqel on 2018/10/15.
 */

public class XXXHelper {

    private static XXXHelper xxxHelper ;

    private Context context;

    private TextView mtextview;


    private XXXHelper(Context context
    ) {
        this.context = context;

    }
    public static XXXHelper getIntance(Context context) {
        synchronized (XXXHelper.class) {
            if(xxxHelper == null){
               xxxHelper = new XXXHelper(context);
            }else{
                return xxxHelper;
            }
            return xxxHelper;
        }
    }

    public void setRetainedTextView(TextView textView){
        this.mtextview = textView;
        mtextview.setText(context.getResources().getString(R.string.label));
    }


}
