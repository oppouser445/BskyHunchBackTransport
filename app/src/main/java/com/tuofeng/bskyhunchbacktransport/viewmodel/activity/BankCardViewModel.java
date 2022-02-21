package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IBankCardView;
import com.tuofeng.bskyhunchbacktransport.module.data.BankCardRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class BankCardViewModel extends BaseViewModel<IBankCardView, BankCardRepository> {

    private final String TAG = "BankCardViewModel";
    private String mData = "";

    public BankCardViewModel(IBankCardView iv) {
        super(iv, new BankCardRepository());
    }
}