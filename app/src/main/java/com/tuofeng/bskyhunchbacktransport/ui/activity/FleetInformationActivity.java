package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityFleetInformationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IFleetInformationView;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.FleetInformationViewModel;

public class FleetInformationActivity extends BaseActivity<ActivityFleetInformationBinding, FleetInformationViewModel> implements IFleetInformationView {

    private SharedButton mBtnOk;
    private LinearLayout mLlyaoutFleetInformation,mLlyaoutApplyJoinTeam;
    private TextView mTvContent;
    private SharedButton mBtnGoCertification;
    private ImageView mImageApplyIcon;
    private TextView mTvApplyTitle,mTvApplyContent;

    @Override
    protected FleetInformationViewModel getViewModel() {
        return new FleetInformationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fleet_information;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("车队信息");
        mDataBinding.setViewModel(mViewModel);

        //lLyaout_fleet_information
        mLlyaoutFleetInformation = mDataBinding.lLyaoutFleetInformation;
        mBtnOk = mDataBinding.btnOk;

        mTvContent = mDataBinding.tvContent;

        //申请入队
        mLlyaoutApplyJoinTeam = mDataBinding.lLyaoutApplyJoinTeam;

        //我的车队 申请流程
        //btn_go_certification
        mBtnGoCertification = mDataBinding.btnGoCertification;

        //图标 image_apply_icon
        mImageApplyIcon = mDataBinding.imageApplyIcon;
        //标题
        mTvApplyTitle = mDataBinding.tvApplyTitle;
        //内容
        mTvApplyContent = mDataBinding.tvApplyContent;
        //第一个按钮 btn_go_certification
        mBtnGoCertification = mDataBinding.btnGoCertification;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PreviousAction() {

    }

    @Override
    public void NextAction(int type) {
        if (type == 1) {
            mLlyaoutFleetInformation.setVisibility(View.VISIBLE);
            mTvContent.setVisibility(View.GONE);
            mBtnOk.setText("退出车队");
        } else if (type == 2) {
            mToolbarTitle.setText("申请入队");
        }else if (type == 3) {//前往认证
            mToolbarTitle.setText("我的车队");
        }else if (type == 4) {
            mToolbarTitle.setText("我的车队");
        }
    }

    @Override
    public void saveSubmitReview() {

    }
}