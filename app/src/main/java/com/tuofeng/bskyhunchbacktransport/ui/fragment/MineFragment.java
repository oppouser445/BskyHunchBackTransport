package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMineBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMineFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.BannerPagerAdapter;
import com.tuofeng.bskyhunchbacktransport.ui.activity.InformationAuthenticationActivity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.MainActivity;
import com.tuofeng.bskyhunchbacktransport.ui.view.ImageSlideshow;
import com.tuofeng.bskyhunchbacktransport.utils.ViewMyUtils;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.MineFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends BaseFragment<FragmentMineBinding, MineFragmentViewModel> implements IMineFragmentView, View.OnClickListener {

    private MainActivity mActivity;
    private ImageSlideshow mVpUserBanner;
    private BannerPagerAdapter mBannerAdapter;
    private TextView mTvUserCertification;
    private  int[] mImageIds = new int[]{
            R.mipmap.act_main_banner_icon3,
            R.mipmap.act_main_banner_icon1,
            R.mipmap.act_main_banner_icon2,
    };

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
        for (int i = 0;i<mImageIds.length ;i++){
            mVpUserBanner.addImageTitle("", "",mImageIds[i]);
        }
        mVpUserBanner.commit();

        mTvUserCertification = mDataBinding.tvUserCertification;
        mTvUserCertification.setOnClickListener(this);
    }

    @Override
    void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_user_certification:
                Intent intent = new Intent(mActivity, InformationAuthenticationActivity.class);
                startActivity(intent);
                break;
        }
    }
}