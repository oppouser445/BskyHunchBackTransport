package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityVehicleBasicInformationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IVehicBasiclnformationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.VehicleBasicInformationViewModel;

public class VehicleBasicInformationActivity extends BaseActivity<ActivityVehicleBasicInformationBinding, VehicleBasicInformationViewModel> implements IVehicBasiclnformationView {
    @Override
    protected VehicleBasicInformationViewModel getViewModel() {
        return new VehicleBasicInformationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vehicle_basic_information;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("车辆基础信息");
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PreviousAction() {
        finish();
    }

    @Override
    public void NextAction() {
        Intent intent = new Intent(this, VehicleCertificationInformationActivity.class);
        startActivity(intent);
    }
}