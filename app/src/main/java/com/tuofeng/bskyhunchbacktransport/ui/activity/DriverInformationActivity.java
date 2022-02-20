package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityDriverInformationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IDriverInformationView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.DriverInformationViewModel;

public class DriverInformationActivity extends BaseActivity<ActivityDriverInformationBinding, DriverInformationViewModel> implements IDriverInformationView {


    @Override
    protected DriverInformationViewModel getViewModel() {
        return new DriverInformationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_driver_information;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("司机信息");
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
        Intent intent = new Intent(this, VehicleBasicInformationActivity.class);
        startActivity(intent);
    }

    @Override
    public void saveSubmitReview() {

    }
}