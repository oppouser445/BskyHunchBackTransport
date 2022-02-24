package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IVehicleInformationView;
import com.tuofeng.bskyhunchbacktransport.module.data.VehicleInformationRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class VehicleInformationVM extends BaseViewModel<IVehicleInformationView, VehicleInformationRepository> {

    private final String TAG = "VehicleInformationVM";
    private String mData="";

    public VehicleInformationVM(IVehicleInformationView iv) {
        super(iv,new VehicleInformationRepository());
    }

}