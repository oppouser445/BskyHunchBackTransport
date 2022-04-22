package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;


import com.tuofeng.bskyhunchbacktransport.contract.WithDrawContract;
import com.tuofeng.bskyhunchbacktransport.module.data.WithDrawRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class WithDrawVM extends BaseViewModel<WithDrawContract.IWithDrawView, WithDrawRepository> {

    private final String TAG = "WithDrawVM";

    public WithDrawVM(WithDrawContract.IWithDrawView iv) {
        super(iv, new WithDrawRepository());
    }

    public void withDrawOnClick(){
        mIView.withDrawOnclick();
    }
}