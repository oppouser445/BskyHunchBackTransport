package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;


import com.tuofeng.bskyhunchbacktransport.in.IConfirmContractView;
import com.tuofeng.bskyhunchbacktransport.module.data.ConfirmContractRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class ConfirmContractViewModel extends BaseViewModel<IConfirmContractView, ConfirmContractRepository> {

    private final String TAG = "ContractConfirmationViewModel";

    public ConfirmContractViewModel(IConfirmContractView iv) {
        super(iv, new ConfirmContractRepository());
    }

    public void PreviousAction() {
        mIView.PreviousAction();
    }

 }