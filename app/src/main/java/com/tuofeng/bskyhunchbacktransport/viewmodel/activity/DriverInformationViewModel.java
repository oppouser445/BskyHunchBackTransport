package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IDriverInformationView;
import com.tuofeng.bskyhunchbacktransport.module.data.DriverInformationRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class DriverInformationViewModel extends BaseViewModel<IDriverInformationView, DriverInformationRepository> {

    private final String TAG = "DriverInformationViewModel";
    private String mData = "";

    public DriverInformationViewModel(IDriverInformationView iv) {
        super(iv, new DriverInformationRepository());
    }

    public void PreviousAction() {
        mIView.PreviousAction();
    }

    public void NextAction() {
        mIView.NextAction();
    }

    public void saveSubmitReview() {
        mIView.saveSubmitReview();
    }
}