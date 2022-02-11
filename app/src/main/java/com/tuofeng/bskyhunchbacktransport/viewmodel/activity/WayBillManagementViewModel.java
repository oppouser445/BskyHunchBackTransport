package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.IMainView;
import com.tuofeng.bskyhunchbacktransport.in.IWayBillManagementView;
import com.tuofeng.bskyhunchbacktransport.module.data.MainRepository;
import com.tuofeng.bskyhunchbacktransport.module.data.WayBillManagementRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class WayBillManagementViewModel extends BaseViewModel<IWayBillManagementView, WayBillManagementRepository> {

    private final String TAG = "WayBillManagementViewModel";
    private String mData="";

    public WayBillManagementViewModel(IWayBillManagementView iv) {
        super(iv,new WayBillManagementRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }

    public void confirmChanges() {
        mIView.confirmChanges();
    }

}