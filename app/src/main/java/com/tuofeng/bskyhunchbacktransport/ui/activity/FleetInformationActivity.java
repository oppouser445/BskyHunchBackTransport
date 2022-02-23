package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.transition.Visibility;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityFleetInformationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IFleetInformationView;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.FleetInformationViewModel;

public class FleetInformationActivity extends BaseActivity<ActivityFleetInformationBinding, FleetInformationViewModel> implements IFleetInformationView {

    private SharedButton mBtnOk;
    private LinearLayout mLlyaoutFleetInformation, mLlyaoutApplyJoinTeam, lLyaout1, mLlyaoutApplyCertification;
    private TextView mTvContent;
    private SharedButton mBtnGoCertification, mBtnTalkAboutLater;
    private ImageView mImageApplyIcon;
    private TextView mTvApplyTitle, mTvApplyContent;
    private boolean mTestFlage;

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

        lLyaout1 = mDataBinding.lLyaout1;

        mLlyaoutFleetInformation = mDataBinding.lLyaoutFleetInformation;
        mBtnOk = mDataBinding.btnOk;

        mTvContent = mDataBinding.tvContent;

        //申请入队
        mLlyaoutApplyJoinTeam = mDataBinding.lLyaoutApplyJoinTeam;

        //我的车队 申请流程
        mImageApplyIcon = mDataBinding.imageApplyIcon;
        //标题
        mTvApplyTitle = mDataBinding.tvApplyTitle;
        //内容
        mTvApplyContent = mDataBinding.tvApplyContent;
        //第一个按钮 btn_go_certification
        mBtnGoCertification = mDataBinding.btnGoCertification;
        //btn_talk_about_later
        mBtnTalkAboutLater = mDataBinding.btnTalkAboutLater;

        //申请认证 界面1
        mLlyaoutApplyCertification = mDataBinding.lLyaoutApplyCertification;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PreviousAction() {

    }

    @Override
    public void NextAction(int type) {
        if (type == 1 && !mTestFlage) {
            mLlyaoutFleetInformation.setVisibility(View.VISIBLE);
            mTvContent.setVisibility(View.GONE);
            mBtnOk.setText("退出车队");
            mTestFlage = true;
        } else if (type == 1) {
            lLyaout1.setVisibility(View.GONE);
            mLlyaoutApplyJoinTeam.setVisibility(View.VISIBLE);
            mToolbarTitle.setText("申请入队");
            mBtnOk.setText("申请加入车队");
        } else if (type == 2) {
            mLlyaoutApplyJoinTeam.setVisibility(View.GONE);
            mLlyaoutApplyCertification.setVisibility(View.VISIBLE);
        } else if (type == 3) {//前往认证
            mToolbarTitle.setText("我的车队");
            mTvApplyTitle.setText("拒绝加入");
            mBtnGoCertification.setText("再次申请");
            mImageApplyIcon.setImageResource(R.mipmap.refuse_join_icon);
            mTvApplyContent.setText("您可以确认信息无误后，再次申请加入车队。 或联系您所在车队的车队长添加您。");
            mBtnTalkAboutLater.setVisibility(View.INVISIBLE);
        } else if (type == 4) {
            mToolbarTitle.setText("我的车队");
        }
    }

    @Override
    public void saveSubmitReview() {

    }
}