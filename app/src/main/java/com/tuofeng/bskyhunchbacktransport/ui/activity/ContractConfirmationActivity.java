package com.tuofeng.bskyhunchbacktransport.ui.activity;


import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityContractConfirmationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IContractConfirmationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.ContractConfirmationViewModel;

public class ContractConfirmationActivity extends BaseActivity<ActivityContractConfirmationBinding, ContractConfirmationViewModel> implements IContractConfirmationView {


    @Override
    protected ContractConfirmationViewModel getViewModel() {
        return new ContractConfirmationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contract_confirmation;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("合同确认");
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PreviousAction() {
        Intent intent = new Intent(this, ConfirmContractActivity.class);
        startActivity(intent);
    }
}