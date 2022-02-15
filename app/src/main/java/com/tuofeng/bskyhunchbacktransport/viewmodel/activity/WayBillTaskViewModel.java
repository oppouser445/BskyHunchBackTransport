package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.IWayBillTaskView;
import com.tuofeng.bskyhunchbacktransport.module.data.WayBillTaskRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class WayBillTaskViewModel extends BaseViewModel<IWayBillTaskView, WayBillTaskRepository>{

    private final String TAG = "SplashViewModel";
    private String mData="";

    public WayBillTaskViewModel(IWayBillTaskView iv) {
        super(iv,new WayBillTaskRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }


    public void BtnClick(int type) {
    }
}