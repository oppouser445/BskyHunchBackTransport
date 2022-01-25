package com.tuofeng.bskyhunchbacktransport.ui.activity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.in.IDriverIdentificationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.DriverIdentificationViewModel;

public class DriverIdentificationActivity extends BaseActivity implements IDriverIdentificationView {

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
    }

    @Override
    protected void initData() {

    }

    @Override
    public void NextInformationAuthentication() {

    }
}