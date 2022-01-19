package com.tuofeng.bskyhunchbacktransport.utils;

import android.util.Log;

import static com.tuofeng.bskyhunchbacktransport.ui.activity.BaseApplication.mIsTestFlage;

public class LogUtils {

    //设为false关闭日志
    private static final boolean LOG_ENABLE = mIsTestFlage;

    public static void i(String tag, String msg){
        if (LOG_ENABLE){
            Log.i(tag, msg);
        }
    }
    public static void v(String tag, String msg){
        if (LOG_ENABLE){
            Log.v(tag, msg);
        }
    }
    public static void d(String tag, String msg){
        if (LOG_ENABLE){
            Log.d(tag, msg);
        }
    }
    public static void w(String tag, String msg){
        if (LOG_ENABLE){
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg){
        if (LOG_ENABLE){
            Log.e(tag, msg);
        }
    }
}
