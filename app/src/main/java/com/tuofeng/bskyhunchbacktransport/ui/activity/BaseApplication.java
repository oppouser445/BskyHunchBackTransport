package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Context;
import android.support.multidex.MultiDex;

import androidx.multidex.MultiDexApplication;

public class BaseApplication extends MultiDexApplication {

    private static BaseApplication baseApp;
    public static boolean mIsTestFlage = true;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApp = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static BaseApplication getInstance() {
        return baseApp;
    }
}
