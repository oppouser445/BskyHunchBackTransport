package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.ExitAppDialog;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class SetUpActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTvExitAap;
    private RelativeLayout mRLyaoutSettingLoginPassword, mRLyaoutSetWithdrawalPassword;
    private Intent intent;

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    @Override
    protected void initView() {
        initTitleBar();

        mToolbarTitle.setText("设置");

        mTvExitAap = findViewById(R.id.tv_exit_aap);
        mTvExitAap.setOnClickListener(this);

        mRLyaoutSettingLoginPassword = findViewById(R.id.rLyaout_setting_login_password);
        mRLyaoutSettingLoginPassword.setOnClickListener(this);

        mRLyaoutSetWithdrawalPassword = findViewById(R.id.rLyaout_set_withdrawal_password);
        mRLyaoutSetWithdrawalPassword.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.rLyaout_set_withdrawal_password:
                intent = new Intent(this, SetWithdrawalPasswordActivity.class);
                break;
            case R.id.rLyaout_setting_login_password:
                intent = new Intent(this, SettingLoginPasswordActivity.class);
                break;
            case R.id.tv_exit_aap:
                ExitAppDialog appDialog = new ExitAppDialog(this);
                appDialog.show();
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}