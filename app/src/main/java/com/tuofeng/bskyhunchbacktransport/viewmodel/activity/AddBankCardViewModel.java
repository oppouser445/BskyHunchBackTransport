package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IAddBankCardView;
import com.tuofeng.bskyhunchbacktransport.in.IBankCardView;
import com.tuofeng.bskyhunchbacktransport.module.data.AddBankCardRepository;
import com.tuofeng.bskyhunchbacktransport.module.data.BankCardRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class AddBankCardViewModel extends BaseViewModel<IAddBankCardView, AddBankCardRepository> {

    private final String TAG = "AddBankCardViewModel";
    private String mData = "";

    public AddBankCardViewModel(IAddBankCardView iv) {
        super(iv, new AddBankCardRepository());
    }

    public void nextActivity(){
        mIView.nextActivity();
    }
}