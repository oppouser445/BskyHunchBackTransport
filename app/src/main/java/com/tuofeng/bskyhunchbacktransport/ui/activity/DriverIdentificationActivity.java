package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityDriverIdentificationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IDriverIdentificationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.DriverIdentificationViewModel;

public class DriverIdentificationActivity extends BaseActivity<ActivityDriverIdentificationBinding, DriverIdentificationViewModel> implements IDriverIdentificationView {

    @Override
    protected DriverIdentificationViewModel getViewModel() {
        return new DriverIdentificationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_driver_identification;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mDataBinding.setViewModel(mViewModel);
        mToolbarTitle.setText("身份认证");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void NextInformationAuthentication() {
        Intent intent = new Intent(this, DriverInformationActivity.class);
        startActivity(intent);
    }
}