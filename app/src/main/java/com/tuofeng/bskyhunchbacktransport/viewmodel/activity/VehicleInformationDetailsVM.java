package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.IVehicleInformationDetailsView;
import com.tuofeng.bskyhunchbacktransport.module.data.VehicleInformationDetailsRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class VehicleInformationDetailsVM extends BaseViewModel<IVehicleInformationDetailsView, VehicleInformationDetailsRepository> {

    private final String TAG = "VehicleInformationDetailsVM";
    private String mData="";

    public VehicleInformationDetailsVM(IVehicleInformationDetailsView iv) {
        super(iv,new VehicleInformationDetailsRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }
}