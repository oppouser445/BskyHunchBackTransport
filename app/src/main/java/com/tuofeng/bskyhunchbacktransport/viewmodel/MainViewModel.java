package com.tuofeng.bskyhunchbacktransport.viewmodel;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.IMainView;
import com.tuofeng.bskyhunchbacktransport.mode.data.MainRepository;

public class MainViewModel extends BaseViewModel<IMainView, MainRepository>{

    private final String TAG = "SplashViewModel";
    private String mData="";

    public MainViewModel(IMainView iv) {
        super(iv,new MainRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }
}