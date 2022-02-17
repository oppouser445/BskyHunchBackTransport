package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.IWayBillDetailsView;
import com.tuofeng.bskyhunchbacktransport.module.data.WayBillDetailsRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class WayBillDetailsViewModel extends BaseViewModel<IWayBillDetailsView, WayBillDetailsRepository>{

    private final String TAG = "WayBillDetailsViewModel";
    private String mData="";

    public WayBillDetailsViewModel(IWayBillDetailsView iv) {
        super(iv,new WayBillDetailsRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }

    public void BtnClick(int type) {
    }
}