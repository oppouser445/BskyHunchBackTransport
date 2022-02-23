package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.in.ISettingLoginPasswordView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class SettingLoginPasswordActivity extends BaseActivity implements ISettingLoginPasswordView {

    private Intent intent;
    private int mViewType;

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting_login_password;
    }

    @Override
    protected void initView() {
        initTitleBar();

        mToolbarTitle.setText("设置");
        intent = getIntent();
        mViewType = intent.getIntExtra("viewType", 0);
        mToolbarTitle.setText(mViewType == 0 ? "设置登录密码" : "修改登录密码");
    }

    @Override
    protected void initData() {

    }
}