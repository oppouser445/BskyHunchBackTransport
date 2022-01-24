package com.tuofeng.bskyhunchbacktransport;

import android.view.View;

import com.tuofeng.bskyhunchbacktransport.ui.activity.BaseActivity;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class InformationAuthenticationActivity extends BaseActivity {

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_information_authentication;
    }

    @Override
    protected void initView() {
        initStatusBar(1);
        initTitleBar();
        mToolbarBack.setOnClickListener(v -> finish());
        mToolbarTitle.setText("请选择正确的角色");
    }

    @Override
    protected void initData() {

    }
}