package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityInformationAuthenticationBinding;
import com.tuofeng.bskyhunchbacktransport.in.InformationAuthenticationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.InformationAuthenticationViewModel;

public class InformationAuthenticationActivity extends BaseActivity<ActivityInformationAuthenticationBinding, InformationAuthenticationViewModel> implements InformationAuthenticationView, View.OnClickListener {

    @Override
    protected InformationAuthenticationViewModel getViewModel() {
        return new InformationAuthenticationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_information_authentication;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarBack.setOnClickListener(v -> finish());
        mToolbarTitle.setText("请选择认证的角色");
        mDataBinding.setViewModel(mViewModel);
        mDataBinding.lLyaoutCarLength.setOnClickListener(this);
        mDataBinding.lLyaoutDriver.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void startCertificationInformationAct(int type) {
        Intent intent = null;
        if (type == 1) {
            intent = new Intent(this, TeamCaptainCertificationActivity.class);
        } else {
            intent = new Intent(this, DriverIdentificationActivity.class);
        }
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lLyaout_driver:
                startCertificationInformationAct(2);
                break;
            case R.id.lLyaout_car_length:
                startCertificationInformationAct(1);
                break;
        }
    }
}