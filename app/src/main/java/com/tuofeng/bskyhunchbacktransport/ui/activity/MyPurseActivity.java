package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityMyPurseBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMyPurseView;
import com.tuofeng.bskyhunchbacktransport.ui.view.ImageSlideshow;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.MyPurseViewModel;

public class MyPurseActivity extends BaseActivity<ActivityMyPurseBinding, MyPurseViewModel> implements IMyPurseView, View.OnClickListener {

    private int[] mImageIds = new int[]{
            R.mipmap.act_main_banner_icon3,
            R.mipmap.act_main_banner_icon1,
            R.mipmap.act_main_banner_icon2,
    };
    private ImageSlideshow mVpBanner;
    private final String TAG = "MyPurseActivity";
    private boolean mPause;

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
        mTvRightClick.setOnClickListener(v -> {
            Intent intent = new Intent(this, BankCardActivity.class);
            startActivity(intent);
        });

        mDataBinding.setViewModel(mViewModel);
        mVpBanner = mDataBinding.vpUserBanner;
        for (int i = 0; i < mImageIds.length; i++) {
            mVpBanner.addImageTitle("", "", mImageIds[i]);
        }
        mVpBanner.setDelay(3000);
        mVpBanner.setOnItemClickListener((view, position) -> {
            if (position == 0) {
                Intent intent = new Intent(this, CollectionInvitationsActivity.class);
                startActivity(intent);
                ToastUtil.shortToast("测试点击");
            }
        });
        mVpBanner.commit();

        //rlayout_my_purse
        mDataBinding.rlayoutMyPurse.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPause) {
            LogUtils.e(TAG, "onResume");
            mVpBanner.startPlay();
        }
        mPause = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        mPause = true;
        mVpBanner.stopPlay();
        LogUtils.e(TAG, "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVpBanner.stopPlay();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlayout_my_purse:
                Intent intent = new Intent(this,WithDrawActivity.class);
                startActivity(intent);
                break;
        }
    }
}