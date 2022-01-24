package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMainBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMainFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.BannerPagerAdapter;
import com.tuofeng.bskyhunchbacktransport.module.adapter.RecycleBannerAdapter;
import com.tuofeng.bskyhunchbacktransport.utils.CommonUtil;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.utils.ViewMyUtils;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.FragmentMainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment<FragmentMainBinding, FragmentMainViewModel> implements IMainFragmentView, View.OnClickListener {

    private ImageView mImgTitleNoticeClear;
    private RelativeLayout mLayoutTitleNoticeHome;
    private ViewPager mVpBanner;
    private BannerPagerAdapter mBannerAdapter;
    private List<Integer> mViewListTest;
    private List<View> mViewList;
    private List<String> mDataList;
    private RecyclerView mRecyclerActHome;
    private RecycleBannerAdapter mRecycleBannerAdapter;
    private FragmentActivity mActivity;
    private int mCurrentPosition = 0;
    private final String TAG = "MainFragment";
    private LinearLayout mLLayoutMainFragmentBannerDots;

    @Override
    int getLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    FragmentMainViewModel getViewModel() {
        return new FragmentMainViewModel(this);
    }

    @Override
    void initView() {
        mActivity = getActivity();
        mImgTitleNoticeClear = mDataBinding.imgTitleNoticeClear;
        mImgTitleNoticeClear.setOnClickListener(this);

        mLayoutTitleNoticeHome = mDataBinding.rlayoutTitleNoticeHome;
        mVpBanner = mDataBinding.vpBanner;
        mViewList = new ArrayList<>();
        mViewListTest = new ArrayList<>();
        mViewListTest.add(R.mipmap.act_main_banner_icon3);
        mViewListTest.add(R.mipmap.act_main_banner_icon1);
        mViewListTest.add(R.mipmap.act_main_banner_icon2);

        for (int i = 0; i < mViewListTest.size(); i++) {
            ImageView imageView = new ImageView(mActivity);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            /*if (i == 0) {
                imageView.setBackgroundResource(mViewListTest.get(mViewListTest.size() - 1));
            } else if (i == 4) {
                imageView.setBackgroundResource(mViewListTest.get(0));
            } else {
                imageView.setBackgroundResource(mViewListTest.get(i - 1));
            }*/
            imageView.setBackgroundResource(mViewListTest.get(i));
            mViewList.add(imageView);
        }
        mBannerAdapter = new BannerPagerAdapter(mViewList, mVpBanner);
        mVpBanner.setAdapter(mBannerAdapter);

        //设置每次加载时第一页在MAX_VALUE / 2 - Extra 页，造成用户无限轮播的错觉
        int startPage = Integer.MAX_VALUE / 2;
        int extra = startPage % mViewList.size();
        startPage = startPage - extra;
        mVpBanner.setCurrentItem(startPage);

        mVpBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //LogUtils.e(TAG, "滑动当前下标 position ==" + position + " 滑动比例 positionOffset == " + getCeilDouble(positionOffset));
                //测出页面滚动时小红点移动的距离，并通过setLayoutParams(params)不断更新其位置
                //测出页面滚动时小红点移动的距离，并通过setLayoutParams(params)不断更新其位置
                /*position = position % mDataList.size();
                float leftMargin = diatance * (position + positionOffset);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mView.getLayoutParams();
                params.leftMargin = Math.round(leftMargin);
                mView.setLayoutParams(params);
                Log.d("红点在这",leftMargin + "");*/
            }

            @Override
            public void onPageSelected(int position) {
                position = position % mViewList.size();
                /*
                mCurrentPosition = position;

                if (position == 0) {
                    position = 1;
                    //LogUtils.e(TAG, "滑动当前下标 position1 ==" + position);
                } else if (position == mViewList.size() - 1) {
                    position = 0;
                   // LogUtils.e(TAG, "滑动当前下标 position2 ==" + position);
                } else {
                    position--;
                    //LogUtils.e(TAG, "滑动当前下标 position3 ==" + position);
                }
                if (mCurrentPosition != position) {
                    //LogUtils.e(TAG, "滑动当前下标 position4 ==" + mCurrentPosition);
                }*/
                //LogUtils.e(TAG, "滑动当前下标 position ==" + position);

                ViewMyUtils.setDotsLayoutStyle(mActivity,position,mLLayoutMainFragmentBannerDots);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // 多于1，才会循环跳转
                /*if (state == 0) {
                    // 如果当前是在首位，那么跳转到倒数第2位
                    if (mCurrentPosition == 0) {
                        //mVpBanner.setCurrentItem(mViewList.size() - 2, false);
                        // 如果当前是在末位，跳转到第2位
                    } else if (mCurrentPosition == mViewList.size() - 1) {
                        //mVpBanner.setCurrentItem(1, false);
                    }
                }*/
            }
        });

        mRecyclerActHome = mDataBinding.recyclerActHome;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        //mRecyclerActHome.setNestedScrollingEnabled(false);
        mRecyclerActHome.setLayoutManager(mLayoutManager);
        mDataList = new ArrayList<>();
        mRecycleBannerAdapter = new RecycleBannerAdapter(mDataList, mActivity);
        mRecyclerActHome.setAdapter(mRecycleBannerAdapter);

        mLLayoutMainFragmentBannerDots = mDataBinding.lLayoutMainFragmentBannerDots;
        /*for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(mActivity);
            int i1 = CommonUtil.px2dp(mActivity, 10);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(i1, i1);
            params.setMargins(i1, i1, i1, i1);
            imageView.setImageResource(R.drawable.shape_main_fragment_dots_default);
            imageView.setLayoutParams(params);
            mLLayoutMainFragmentBannerDots.addView(imageView);
        }*/
        ViewMyUtils.initDotsLayoutStyle(mActivity,mLLayoutMainFragmentBannerDots);
        ViewMyUtils.setDotsLayoutStyle(mActivity,0,mLLayoutMainFragmentBannerDots);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_title_notice_clear:
                mLayoutTitleNoticeHome.setVisibility(View.GONE);
                break;
        }
    }

    /*private void setDotsLayoutStyle(int position) {
        for (int i = 0; i < 3; i++) {
            boolean b = position == i;
            ImageView imageView = (ImageView) mLLayoutMainFragmentBannerDots.getChildAt(i);
            int spacing = CommonUtil.px2dp(mActivity, 10);
            int width = CommonUtil.px2dp(mActivity, b ? 20 : 10);
            int spacingRight = CommonUtil.px2dp(mActivity, b ? 5 : 10);
            LinearLayout.LayoutParams layoutParams = *//*new LinearLayout.LayoutParams(width, high)*//*(LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = width;
            layoutParams.setMargins(spacing, spacing, spacingRight, spacing);
            imageView.setImageResource(b ? R.drawable.shape_main_fragment_dots : R.drawable.shape_main_fragment_dots_default);
            imageView.setLayoutParams(layoutParams);
        }
    }*/
}