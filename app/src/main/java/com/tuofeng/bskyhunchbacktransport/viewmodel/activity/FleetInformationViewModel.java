package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IDriverInformationView;
import com.tuofeng.bskyhunchbacktransport.in.IFleetInformationView;
import com.tuofeng.bskyhunchbacktransport.module.data.DriverInformationRepository;
import com.tuofeng.bskyhunchbacktransport.module.data.FleetInformationRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class FleetInformationViewModel extends BaseViewModel<IFleetInformationView, FleetInformationRepository> {

    private final String TAG = "FleetInformationViewModel";
    private String mData = "";

    public FleetInformationViewModel(IFleetInformationView iv) {
        super(iv, new FleetInformationRepository());
    }

    public void PreviousAction() {
        mIView.PreviousAction();
    }

    public void NextAction(int type) {
        mIView.NextAction(type);
    }

    public void saveSubmitReview() {
        mIView.saveSubmitReview();
    }
}