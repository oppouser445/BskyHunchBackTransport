package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityVehicleCertificationInformationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IVehicleCertificationInformationView;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.VehicleCertificationInformationViewModel;

public class VehicleCertificationInformationActivity extends BaseActivity<ActivityVehicleCertificationInformationBinding, VehicleCertificationInformationViewModel> implements IVehicleCertificationInformationView {

    private Intent intent;
    private int mBtnStyle;
    private SharedButton mBtnPrevious, mBtnKeepVehicleInformation;

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

        intent = getIntent();
        mBtnStyle = intent.getIntExtra("btn_style", 0);

        mBtnPrevious = mDataBinding.btnPrevious;
        mBtnKeepVehicleInformation = mDataBinding.btnKeepVehicleInformation;

        boolean b = mBtnStyle == 0;
        mBtnPrevious.setVisibility(b ? View.VISIBLE : View.GONE);
        mBtnKeepVehicleInformation.setText(b ? "下一步 添加银行卡(4/6)" : "保持(2/2)");
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
        if (mBtnStyle == 1) {
            finish();
        } else {
            Intent intent = new Intent(this, InformationAuthenticationBankCardActivity.class);
            startActivity(intent);
        }
    }
}