package com.tuofeng.bskyhunchbacktransport.ui.activity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.in.IVehicleInformationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.VehicleInformationVM;

public class VehicleInformationActivity extends BaseActivity implements IVehicleInformationView {

    @Override
    protected VehicleInformationVM getViewModel() {
        return new VehicleInformationVM(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vehicle_information;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("意见与投诉");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void NextAction() {

    }
}