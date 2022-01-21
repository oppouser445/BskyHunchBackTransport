package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMineBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMineFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.BannerPagerAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.MineFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends BaseFragment<FragmentMineBinding, MineFragmentViewModel> implements IMineFragmentView {

    private FragmentActivity mActivity;
    private ViewPager vpUserBanner;
    private ArrayList<Integer> mViewListTest;
    private List<View> mViewList;
    private BannerPagerAdapter mBannerAdapter;

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
        mBannerAdapter = new BannerPagerAdapter(mViewList);
        vpUserBanner.setAdapter(mBannerAdapter);
    }

    @Override
    int getLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    MineFragmentViewModel getViewModel() {
        return new MineFragmentViewModel(this);
    }
}