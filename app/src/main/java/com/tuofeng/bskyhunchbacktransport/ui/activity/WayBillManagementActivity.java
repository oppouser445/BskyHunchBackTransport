package com.tuofeng.bskyhunchbacktransport.ui.activity;


import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class WayBillManagementActivity extends BaseFragmentActivity {

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_waybill_management;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("安排/改派司机");
    }

    @Override
    protected void initData() {

    }
}