package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMainBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMainFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.BannerPagerAdapter;
import com.tuofeng.bskyhunchbacktransport.module.adapter.RecycleBannerAdapter;
import com.tuofeng.bskyhunchbacktransport.ui.view.ImageSlideshow;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.FragmentMainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment<FragmentMainBinding, FragmentMainViewModel> implements IMainFragmentView, View.OnClickListener {

    private ImageView mImgTitleNoticeClear;
    private RelativeLayout mLayoutTitleNoticeHome;
    private ImageSlideshow mVpBanner;
    private BannerPagerAdapter mBannerAdapter;
    private List<ImageView> mViewList;
    private List<String> mDataList;
    private RecyclerView mRecyclerActHome;
    private RecycleBannerAdapter mRecycleBannerAdapter;
    private FragmentActivity mActivity;
    private final String TAG = "MainFragment";
    private float mNoticeHeight;
    private  int[] mImageIds = new int[]{
            R.mipmap.act_main_banner_icon3,
            R.mipmap.act_main_banner_icon1,
            R.mipmap.act_main_banner_icon2,
    };

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

        mNoticeHeight = getResources().getDimension(R.dimen.dp_26_5);

        mVpBanner = mDataBinding.vpBanner;
        mVpBanner.setDelay(2000);

        mViewList = new ArrayList<>();

        for (int i = 0;i<mImageIds.length ;i++){
            mVpBanner.addImageTitle("", "",mImageIds[i]);
        }
        mVpBanner.commit();

        mRecyclerActHome = mDataBinding.recyclerActHome;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        //mRecyclerActHome.setNestedScrollingEnabled(false);
        mRecyclerActHome.setLayoutManager(mLayoutManager);
        mDataList = new ArrayList<>();
        mRecycleBannerAdapter = new RecycleBannerAdapter(mDataList, mActivity);
        mRecyclerActHome.setAdapter(mRecycleBannerAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mVpBanner.releaseResource();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_title_notice_clear:
                setNoticeViewStyle(true);
                break;
        }
    }

    private void setNoticeViewStyle(boolean isClosureView) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(isClosureView ? mNoticeHeight : 0, isClosureView ? 0 : mNoticeHeight);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(animation -> {
            float curValue = (float) animation.getAnimatedValue();
            LogUtils.e(TAG, "----curValue:" + (int) curValue);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mLayoutTitleNoticeHome.getLayoutParams();
            layoutParams.height = (int) curValue;
            mLayoutTitleNoticeHome.setLayoutParams(layoutParams);
        });
        valueAnimator.start();
    }
}