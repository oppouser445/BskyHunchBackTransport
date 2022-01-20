package com.tuofeng.bskyhunchbacktransport.viewmodel;

import android.text.TextUtils;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.tuofeng.bskyhunchbacktransport.BR;
import com.tuofeng.bskyhunchbacktransport.in.ISplashView;
import com.tuofeng.bskyhunchbacktransport.module.data.SplashRepository;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;

public class SplashViewModel extends BaseViewModel<ISplashView,SplashRepository>{

    private final String TAG = "SplashViewModel";
    public final ObservableField<String> testDataString = new ObservableField<>();
    private String mData="";

    public SplashViewModel(ISplashView iv) {
        super(iv,new SplashRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }

    public void getUserData() {
        final String[] data = new String[1];
        mDataSource.getUserData("https://www.baidu.com/", baseBean -> {
            data[0] = (String) baseBean.getData();
            setData(data[0]);
        }, baseBean -> {
            data[0] =(String) baseBean.getData();
            setData(data[0]);
        });
    }

    private void setData(String data) {
        LogUtils.e(TAG,data+"");
        testDataString.set(TextUtils.isEmpty(data) ? "暂无数据" : "获取到数据");
        mData = "Bindable方式成功";
        notifyPropertyChanged(BR.testData);
        mIView.startLoginAct();
    }
}