package com.tuofeng.bskyhunchbacktransport.ui.activity;

import androidx.viewpager.widget.ViewPager;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.generated.callback.OnClickListener;
import com.tuofeng.bskyhunchbacktransport.module.adapter.FPagerAdapter;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.BaseFragment;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.HistoricalWaybillFragment;
import com.tuofeng.bskyhunchbacktransport.ui.view.slidingTabLayout.SlidingTabLayout;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoricalWayBillActivity extends BaseFragmentActivity {

    private ViewPager mViewPage;
    private List<BaseFragment> mFragmentList;
    private SlidingTabLayout mTabLayout;

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_historical_way_bill;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("历史运单");

        mViewPage = findViewById(R.id.vp_data);
        mFragmentList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            mFragmentList.add(HistoricalWaybillFragment.newInstance(i + ""));
        }

        mViewPage.setAdapter(new FPagerAdapter(getSupportFragmentManager(), mFragmentList));

        mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*mPosition = position;*/
                mViewPage.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout = findViewById(R.id.tl_2);
        mTabLayout.setViewPager(mViewPage, new String[]{"全部", "未结算", "已结算"});
    }

    @Override
    protected void initData() {

    }
}