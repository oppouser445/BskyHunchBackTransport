package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMineBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMineFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.BannerPagerAdapter;
import com.tuofeng.bskyhunchbacktransport.ui.activity.DriverInformation2Activity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.FleetInformationActivity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.HistoricalWayBillActivity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.InformationAuthenticationActivity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.MainActivity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.MyPurseActivity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.SetUpActivity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.VehicleBasicInformationActivity;
import com.tuofeng.bskyhunchbacktransport.ui.view.ImageSlideshow;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.utils.ViewMyUtils;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.MineFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends BaseFragment<FragmentMineBinding, MineFragmentViewModel> implements IMineFragmentView, View.OnClickListener {

    private MainActivity mActivity;
    private ImageSlideshow mVpUserBanner;
    private BannerPagerAdapter mBannerAdapter;
    private TextView mTvUserCertification;
    private int[] mImageIds = new int[]{
            R.mipmap.act_main_banner_icon3,
            R.mipmap.act_main_banner_icon1,
            R.mipmap.act_main_banner_icon2,
    };
    private RelativeLayout mRlHistoricalwaybill;
    private final String TAG = "MineFragment";
    private boolean mPause;
    private boolean mHidden;

    @Override
    int getLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    MineFragmentViewModel getViewModel() {
        return new MineFragmentViewModel(this);
    }

    @Override
    void initView() {
        mActivity = (MainActivity) getActivity();
        mVpUserBanner = mDataBinding.vpUserBanner;
        for (int i = 0; i < mImageIds.length; i++) {
            mVpUserBanner.addImageTitle("", "", mImageIds[i]);
        }
        mVpUserBanner.commit();

        mTvUserCertification = mDataBinding.tvUserCertification;
        mTvUserCertification.setOnClickListener(this);

        //rlayout_my_purse
        mRlHistoricalwaybill = mDataBinding.rlHistoricalwaybill;
        mRlHistoricalwaybill.setOnClickListener(this);

        mDataBinding.rlayoutMyPurse.setOnClickListener(this);

        mDataBinding.lLyaoutPersonalInformation.setOnClickListener(this);
        mDataBinding.lLyaoutVehicleInformation.setOnClickListener(this);
        mDataBinding.lLyaoutMyFleet.setOnClickListener(this);

        //服务 列表
        mDataBinding.lLyaoutSetUp.setOnClickListener(this);
    }

    @Override
    void initData() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtils.e(TAG, "onHiddenChanged == " + hidden);
        if (hidden) {
            //相当于Fragment的onPause
            mVpUserBanner.stopPlay();
            mHidden = mHidden;
            mHidden = true;
        } else {
            // 相当于Fragment的onResume
            mVpUserBanner.startPlay();
            mHidden = false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPause && !mHidden) {
            LogUtils.e(TAG, "onResume");
            mVpUserBanner.startPlay();
        }
        mPause = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        mPause = true;
        mVpUserBanner.stopPlay();
        LogUtils.e(TAG, "onPause");
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.lLyaout_set_up:
                intent = new Intent(mActivity, SetUpActivity.class);
                break;
            case R.id.lLyaout_my_fleet:
                intent = new Intent(mActivity, FleetInformationActivity.class);
                break;
            case R.id.lLyaout_vehicle_information:
                intent = new Intent(mActivity, VehicleBasicInformationActivity.class);
                intent.putExtra("btn_style", 1);
                break;
            case R.id.lLyaout_personal_information:
                intent = new Intent(mActivity, DriverInformation2Activity.class);
                break;
            case R.id.rlayout_my_purse:
                mVpUserBanner.stopPlay();
                intent = new Intent(mActivity, MyPurseActivity.class);
                break;
            case R.id.rl_historicalwaybill:
                intent = new Intent(mActivity, HistoricalWayBillActivity.class);
                break;
            case R.id.tv_user_certification:
                intent = new Intent(mActivity, InformationAuthenticationActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override
    public void startHistoricalWayBillActivity() {

    }
}