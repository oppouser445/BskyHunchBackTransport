package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IVehicBasiclnformationView;
import com.tuofeng.bskyhunchbacktransport.module.data.VehicleBasicInformationRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class VehicleBasicInformationViewModel extends BaseViewModel<IVehicBasiclnformationView, VehicleBasicInformationRepository> {

    private final String TAG = "VehicleBasicInformationViewModel";
    private String mData = "";

    public VehicleBasicInformationViewModel(IVehicBasiclnformationView iv) {
        super(iv, new VehicleBasicInformationRepository());
    }

    public void PreviousAction() {
        mIView.PreviousAction();
    }

    public void NextAction() {
        mIView.NextAction();
    }
}