package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.footer.MyFooter;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.header.MyHeader;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshFooter;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshHeader;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshLayout;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.listener.DefaultRefreshFooterCreator;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.listener.DefaultRefreshHeaderCreator;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;

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
        initSmartRefreshLayout();
    }

    private void initSmartRefreshLayout() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new MyHeader(context));

        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new MyFooter(context));
    }

    public static BaseApplication getInstance() {
        return baseApp;
    }
}