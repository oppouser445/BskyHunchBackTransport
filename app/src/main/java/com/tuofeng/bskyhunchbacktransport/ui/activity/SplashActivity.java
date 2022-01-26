package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivitySplashBinding;
import com.tuofeng.bskyhunchbacktransport.in.ISplashView;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.SplashViewModel;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements ISplashView {

    @Override
    protected SplashViewModel getViewModel() {
        return new SplashViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void initData() {
        mViewModel.getUserData();
    }

    @Override
    public void startLoginAct() {
        Intent intent = new Intent(this,MainActivity.class);
        //Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}