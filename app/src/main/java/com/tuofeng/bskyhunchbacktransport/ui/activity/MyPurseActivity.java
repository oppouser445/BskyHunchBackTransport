package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityMyPurseBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMyPurseView;
import com.tuofeng.bskyhunchbacktransport.ui.view.ImageSlideshow;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.MyPurseViewModel;

public class MyPurseActivity extends BaseActivity<ActivityMyPurseBinding, MyPurseViewModel> implements IMyPurseView {

    private int[] mImageIds = new int[]{
            R.mipmap.act_main_banner_icon3,
            R.mipmap.act_main_banner_icon1,
            R.mipmap.act_main_banner_icon2,
    };
    private ImageSlideshow mVpBanner;
    private final String TAG = "MyPurseActivity";

    @Override
    protected MyPurseViewModel getViewModel() {
        return new MyPurseViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_purse;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("我的钱包");
        mTvRightClick.setText("银行卡");
        mTvRightClick.setVisibility(View.VISIBLE);

        mDataBinding.setViewModel(mViewModel);
        mVpBanner = mDataBinding.vpUserBanner;
        for (int i = 0; i < mImageIds.length; i++) {
            mVpBanner.addImageTitle("", "", mImageIds[i]);
        }
        mVpBanner.setDelay(3000);
        mVpBanner.setOnItemClickListener((view, position) -> {
            if (position == 0) {

            }
        });

        mVpBanner.commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        mVpBanner.stopPlay();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mVpBanner.startPlay();
    }
}