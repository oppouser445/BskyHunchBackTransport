package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityInformationAuthenticationBankCardBinding;
import com.tuofeng.bskyhunchbacktransport.in.InformationAuthenticationBankCardView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.InformationAuthenticationBankCardViewModel;

public class InformationAuthenticationBankCardActivity extends BaseActivity<ActivityInformationAuthenticationBankCardBinding, InformationAuthenticationBankCardViewModel> implements InformationAuthenticationBankCardView {


    @Override
    protected InformationAuthenticationBankCardViewModel getViewModel() {
        return new InformationAuthenticationBankCardViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_information_authentication_bank_card;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("银行卡");
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PreviousAction() {
        finish();
    }

    @Override
    public void NextAction() {
        Intent intent = new Intent(this, ContractConfirmationActivity.class);
        startActivity(intent);
    }
}