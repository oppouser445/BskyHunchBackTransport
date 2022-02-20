package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityDriverInformation2Binding;
import com.tuofeng.bskyhunchbacktransport.in.IDriverInformationView;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.DriverInformationViewModel;

public class DriverInformation2Activity extends BaseActivity<ActivityDriverInformation2Binding, DriverInformationViewModel> implements IDriverInformationView, View.OnClickListener {


    private TextView mTvReUpload1;
    private TextView mTvReUpload2;
    private SharedButton mBtnSaveSubmitReview;
    private boolean mIsShowView;

    @Override
    protected DriverInformationViewModel getViewModel() {
        return new DriverInformationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_driver_information2;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mDataBinding.setViewModel(mViewModel);
        mToolbarTitle.setText("司机信息");
        mTvRightClick.setText("编辑");
        mTvRightClick.setVisibility(View.VISIBLE);

        mTvReUpload1 = mDataBinding.tvReUpload1;
        mTvReUpload2 = mDataBinding.tvReUpload2;
        mBtnSaveSubmitReview = mDataBinding.btnSaveSubmitReview;

        mTvRightClick.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PreviousAction() {

    }

    @Override
    public void NextAction() {

    }

    @Override
    public void saveSubmitReview() {
        finish();
    }

    @Override
    public void onClick(View v) {
        mIsShowView = !mIsShowView;
        mTvReUpload1.setVisibility(mIsShowView ? View.VISIBLE : View.GONE);
        mTvReUpload2.setVisibility(mIsShowView ? View.VISIBLE : View.GONE);
        mBtnSaveSubmitReview.setVisibility(mIsShowView ? View.VISIBLE : View.INVISIBLE);
    }
}
