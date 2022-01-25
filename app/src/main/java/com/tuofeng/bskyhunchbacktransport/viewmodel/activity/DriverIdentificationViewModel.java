package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IDriverIdentificationView;
import com.tuofeng.bskyhunchbacktransport.module.data.DriverIdentificationRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class DriverIdentificationViewModel extends BaseViewModel<IDriverIdentificationView, DriverIdentificationRepository> {

    private final String TAG = "DriverIdentificationViewModel";
    private String mData = "";

    public DriverIdentificationViewModel(IDriverIdentificationView iv) {
        super(iv, new DriverIdentificationRepository());
    }

    public void NextInformationAuthentication() {
        mIView.NextInformationAuthentication();
     }
}