package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;


import com.tuofeng.bskyhunchbacktransport.in.IContractConfirmationView;
import com.tuofeng.bskyhunchbacktransport.module.data.ContractConfirmationRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class ContractConfirmationViewModel extends BaseViewModel<IContractConfirmationView, ContractConfirmationRepository> {

    private final String TAG = "ContractConfirmationViewModel";

    public ContractConfirmationViewModel(IContractConfirmationView iv) {
        super(iv, new ContractConfirmationRepository());
    }

    public void PreviousAction() {
        mIView.PreviousAction();
    }

 }