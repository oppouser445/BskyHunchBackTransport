package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;


import com.tuofeng.bskyhunchbacktransport.in.IVehicleCertificationInformationView;
import com.tuofeng.bskyhunchbacktransport.module.data.VehicleCertificationInformationRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class VehicleCertificationInformationViewModel extends BaseViewModel<IVehicleCertificationInformationView, VehicleCertificationInformationRepository> {

    private final String TAG = "VehicleCertificationInformationViewModel";
    private String mData = "";

    public VehicleCertificationInformationViewModel(IVehicleCertificationInformationView iv) {
        super(iv, new VehicleCertificationInformationRepository());
    }

    public void PreviousAction() {
        mIView.PreviousAction();
    }

    public void NextAction() {
        mIView.NextAction();
    }
}