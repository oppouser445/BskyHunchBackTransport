package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityVehicleBasicInformationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IVehicBasiclnformationView;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.VehicleBasicInformationViewModel;

public class VehicleBasicInformationActivity extends BaseActivity<ActivityVehicleBasicInformationBinding, VehicleBasicInformationViewModel> implements IVehicBasiclnformationView {

    private SharedButton mBtnPrevious;
    private SharedButton mBtnVehicleBasicInformationNext;
    private Intent intent;
    private int mBtnStyle;

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

        mBtnPrevious = mDataBinding.btnPrevious;
        mBtnVehicleBasicInformationNext = mDataBinding.btnVehicleBasicInformationNext;

        intent = getIntent();
        mBtnStyle = intent.getIntExtra("btn_style", 0);

        boolean b = mBtnStyle == 0;
        mBtnPrevious.setVisibility(b ? View.VISIBLE : View.GONE);
        mBtnVehicleBasicInformationNext.setText(b ? "下一步 添加车辆证件信息(3/6)" : "下一步 添加车辆证件信息(1/2)");
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
        intent.putExtra("btn_style",mBtnStyle);
        startActivity(intent);
    }
}