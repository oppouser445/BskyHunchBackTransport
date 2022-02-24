package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivitySettingLoginPasswordBinding;
import com.tuofeng.bskyhunchbacktransport.in.ISettingLoginPasswordView;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.SettingLoginPasswordVM;

public class SettingLoginPasswordActivity extends BaseActivity<ActivitySettingLoginPasswordBinding, SettingLoginPasswordVM> implements ISettingLoginPasswordView, View.OnClickListener {

    private Intent intent;
    private int mViewType;
    private LinearLayout mLlyaoutNewPassword;
    private SharedButton mBtnOk;

    @Override
    protected SettingLoginPasswordVM getViewModel() {
        return new SettingLoginPasswordVM(this);
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

        mViewType = intent.getIntExtra("type", 0);

        mLlyaoutNewPassword = mDataBinding.lLyaoutNewPassword;

        mLlyaoutNewPassword.setVisibility(mViewType == 0 ? View.GONE : View.VISIBLE);

        mBtnOk = mDataBinding.btnOk;
        mBtnOk.setText("确认保存");

        mBtnOk.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_ok:
                if (mLlyaoutNewPassword.getVisibility() == View.VISIBLE) {
                    intent = new Intent(this, SettingLoginPasswordActivity.class);
                } else {
                    mLlyaoutNewPassword.setVisibility(View.VISIBLE);
                }
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}