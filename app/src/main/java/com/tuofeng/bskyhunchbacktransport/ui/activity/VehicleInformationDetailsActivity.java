package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityVehicleInformationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IVehicleInformationDetailsView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.VehicleInformationDetailsVM;

public class VehicleInformationDetailsActivity extends BaseActivity<ActivityVehicleInformationBinding,VehicleInformationDetailsVM> implements IVehicleInformationDetailsView {

    @Override
    protected VehicleInformationDetailsVM getViewModel() {
        return new VehicleInformationDetailsVM(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vehicle_information_details;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("车辆信息详情");
        mTvRightClick.setText("修改");
        mTvRightClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initData() {

    }
}