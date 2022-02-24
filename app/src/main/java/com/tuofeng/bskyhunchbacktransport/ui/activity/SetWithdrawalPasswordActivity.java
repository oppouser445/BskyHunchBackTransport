package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class SetWithdrawalPasswordActivity extends BaseActivity {

    private LinearLayout mLlyaoutSetPassword,mLlyaoutForgotPassword;
    private TextView mTvForgotPassword;

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_withdrawal_password;
    }

    @Override
    protected void initView() {
        initTitleBar();
        //设置密码布局
        mLlyaoutSetPassword = findViewById(R.id.lLyaout_set_password);
        mLlyaoutForgotPassword = findViewById(R.id.lLyaout_forgot_password);

        mTvForgotPassword = findViewById(R.id.tv_forgot_password);

        mTvForgotPassword.setOnClickListener(v -> {
            mLlyaoutSetPassword.setVisibility(View.GONE);
            mLlyaoutForgotPassword.setVisibility(View.VISIBLE);
        });
    }

    @Override
    protected void initData() {

    }
}