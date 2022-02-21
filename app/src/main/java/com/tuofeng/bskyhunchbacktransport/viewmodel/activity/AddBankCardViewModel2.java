package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IAddBankCardView2;
import com.tuofeng.bskyhunchbacktransport.module.data.AddBankCardRepository2;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class AddBankCardViewModel2 extends BaseViewModel<IAddBankCardView2, AddBankCardRepository2> {

    private final String TAG = "AddBankCardViewModel";
    private String mData = "";

    public AddBankCardViewModel2(IAddBankCardView2 iv) {
        super(iv, new AddBankCardRepository2());
    }

    public void nextActivity(){
        mIView.nextActivity();
    }
}