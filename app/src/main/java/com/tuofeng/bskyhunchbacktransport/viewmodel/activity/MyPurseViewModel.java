package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.IMyPurseView;
import com.tuofeng.bskyhunchbacktransport.module.data.MyPurseRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class MyPurseViewModel extends BaseViewModel<IMyPurseView, MyPurseRepository> {

    private final String TAG = "MyPurseViewModel";
    private String mData = "";

    public MyPurseViewModel(IMyPurseView iv) {
        super(iv, new MyPurseRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }
}