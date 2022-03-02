package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.IFleetManagementV;
import com.tuofeng.bskyhunchbacktransport.module.data.FleetManagementRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class FleetManagementVM extends BaseViewModel<IFleetManagementV, FleetManagementRepository> {

    private final String TAG = "FleetManagementVM";
    private String mData="";

    public FleetManagementVM(IFleetManagementV iv) {
        super(iv,new FleetManagementRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }
}