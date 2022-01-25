package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.InformationAuthenticationView;
import com.tuofeng.bskyhunchbacktransport.module.data.InformationAuthenticationRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class InformationAuthenticationViewModel extends BaseViewModel<InformationAuthenticationView, InformationAuthenticationRepository> {

    private final String TAG = "InformationAuthenticationViewModel";
    private String mData = "";

    public InformationAuthenticationViewModel(InformationAuthenticationView iv) {
        super(iv, new InformationAuthenticationRepository());
    }

    public void startCertificationInformationAct(int type) {
        mIView.startCertificationInformationAct(type);
    }
}