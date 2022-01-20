package com.tuofeng.bskyhunchbacktransport;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.tuofeng.bskyhunchbacktransport.in.IMainView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.BannerPagerAdapter;
import com.tuofeng.bskyhunchbacktransport.module.adapter.RecycleBannerAdapter;
import com.tuofeng.bskyhunchbacktransport.ui.activity.BaseActivity;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.MainViewModel;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements IMainView, View.OnClickListener {

    private ImageView mImgTitleNoticeClear;
    private RelativeLayout mLayoutTitleNoticeHome;
    private ViewPager mVpBanner;
    private BannerPagerAdapter mBannerAdapter;
    private List<Integer> mViewListTest;
    private List<View> mViewList;
    private List<String> mDataList;
    private RecyclerView mRecyclerActHome;
    private RecycleBannerAdapter mRecycleBannerAdapter;

    @Override
    protected MainViewModel getViewModel() {
        return new MainViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setTransparentStatusBar(getWindow(), 1);
        mImgTitleNoticeClear = mDataBinding.imgTitleNoticeClear;
        mImgTitleNoticeClear.setOnClickListener(this);

        //rlayout_title_notice_home
        mLayoutTitleNoticeHome = mDataBinding.rlayoutTitleNoticeHome;

        mVpBanner = mDataBinding.vpBanner;
        mViewList = new ArrayList<>();
        mViewListTest = new ArrayList<>();
        mViewListTest.add(R.mipmap.act_main_banner_icon3);
        mViewListTest.add(R.mipmap.act_main_banner_icon1);
        mViewListTest.add(R.mipmap.act_main_banner_icon2);
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setBackgroundResource(mViewListTest.get(i));
            mViewList.add(imageView);
        }
        mBannerAdapter = new BannerPagerAdapter(mViewList);
        mVpBanner.setAdapter(mBannerAdapter);

        mRecyclerActHome = mDataBinding.recyclerActHome;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //mRecyclerActHome.setNestedScrollingEnabled(false);
        mRecyclerActHome.setLayoutManager(mLayoutManager);

        mDataList = new ArrayList<>();
        mRecycleBannerAdapter = new RecycleBannerAdapter(mDataList, this);

        mRecyclerActHome.setAdapter(mRecycleBannerAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_title_notice_clear:
                mLayoutTitleNoticeHome.setVisibility(View.GONE);
                break;
        }
    }
}