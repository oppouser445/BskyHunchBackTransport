package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityVehicleCertificationInformationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IVehicleCertificationInformationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.VehicleCertificationInformationViewModel;

public class VehicleCertificationInformationActivity extends BaseActivity<ActivityVehicleCertificationInformationBinding, VehicleCertificationInformationViewModel> implements IVehicleCertificationInformationView {

    @Override
    protected VehicleCertificationInformationViewModel getViewModel() {
        return new VehicleCertificationInformationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vehicle_certification_information;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("车辆证件信息");
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
        Intent intent = new Intent(this, InformationAuthenticationBankCardActivity.class);
        startActivity(intent);
    }
}