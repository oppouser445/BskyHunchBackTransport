package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMineBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMineFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.BannerPagerAdapter;
import com.tuofeng.bskyhunchbacktransport.utils.ViewMyUtils;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.MineFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends BaseFragment<FragmentMineBinding, MineFragmentViewModel> implements IMineFragmentView {

    private FragmentActivity mActivity;
    private ViewPager vpUserBanner;
    private ArrayList<Integer> mViewListTest;
    private List<View> mViewList;
    private BannerPagerAdapter mBannerAdapter;
    private LinearLayout mlLayoutMainFragmentBannerDots;

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
        mActivity = getActivity();
        vpUserBanner = mDataBinding.vpUserBanner;
        mViewListTest = new ArrayList<>();
        mViewListTest.add(R.mipmap.act_main_banner_icon3);
        mViewListTest.add(R.mipmap.act_main_banner_icon1);
        mViewListTest.add(R.mipmap.act_main_banner_icon2);

        mViewList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(mActivity);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setBackgroundResource(mViewListTest.get(i));
            mViewList.add(imageView);
        }
        mBannerAdapter = new BannerPagerAdapter(mViewList,vpUserBanner);
        vpUserBanner.setAdapter(mBannerAdapter);

        mlLayoutMainFragmentBannerDots = mDataBinding.lLayoutMainFragmentBannerDots;

        //设置每次加载时第一页在MAX_VALUE / 2 - Extra 页，造成用户无限轮播的错觉
        int startPage = Integer.MAX_VALUE / 2;
        int extra = startPage % mViewList.size();
        startPage = startPage - extra;
        vpUserBanner.setCurrentItem(startPage);

        vpUserBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

                ViewMyUtils.setDotsLayoutStyle(mActivity,position,mlLayoutMainFragmentBannerDots);
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
        ViewMyUtils.initDotsLayoutStyle(mActivity,mlLayoutMainFragmentBannerDots);
        ViewMyUtils.setDotsLayoutStyle(mActivity,0,mlLayoutMainFragmentBannerDots);
    }
}