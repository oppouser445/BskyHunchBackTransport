package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.view.View;
import android.widget.ImageView;
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
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(mActivity);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setBackgroundResource(mViewListTest.get(i));
            mViewList.add(imageView);
        }
        mBannerAdapter = new BannerPagerAdapter(mViewList);
        mVpBanner.setAdapter(mBannerAdapter);

        mRecyclerActHome = mDataBinding.recyclerActHome;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        //mRecyclerActHome.setNestedScrollingEnabled(false);
        mRecyclerActHome.setLayoutManager(mLayoutManager);

        mDataList = new ArrayList<>();
        mRecycleBannerAdapter = new RecycleBannerAdapter(mDataList, mActivity);

        mRecyclerActHome.setAdapter(mRecycleBannerAdapter);
    }

    @Override
    int getLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    FragmentMainViewModel getViewModel() {
        return new FragmentMainViewModel(this);
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