package com.tuofeng.bskyhunchbacktransport.ui.activity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class AddFleetActivity extends BaseActivity {


    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_fleet;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("我的车队");
    }

    @Override
    protected void initData() {

    }
}