package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;


import com.tuofeng.bskyhunchbacktransport.in.InformationAuthenticationBankCardView;
import com.tuofeng.bskyhunchbacktransport.module.data.InformationAuthenticationBaankCardRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class InformationAuthenticationBankCardViewModel extends BaseViewModel<InformationAuthenticationBankCardView, InformationAuthenticationBaankCardRepository> {

    private final String TAG = "InformationAuthenticationBankCardViewModel";
    private String mData = "";

    public InformationAuthenticationBankCardViewModel(InformationAuthenticationBankCardView iv) {
        super(iv, new InformationAuthenticationBaankCardRepository());
    }

    public void PreviousAction() {
        mIView.PreviousAction();
    }

    public void NextAction() {
        mIView.NextAction();
    }
}