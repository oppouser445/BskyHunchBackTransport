package com.tuofeng.bskyhunchbacktransport.ui.activity;


import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class TeamCaptainCertificationReview extends BaseActivity {


    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teamcaptain_certification_review;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarBack.setOnClickListener(v -> finish());
        mToolbarTitle.setText("车队长认证");
    }

    @Override
    protected void initData() {

    }
}