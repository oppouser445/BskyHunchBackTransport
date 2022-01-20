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
import com.tuofeng.bskyhunchbacktransport.ui.activity.BaseFragmentActivity;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.MainFragment;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.SupplyHallFragment;
import com.tuofeng.bskyhunchbacktransport.utils.FragmentUtils;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.MainViewModel;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseFragmentActivity<ActivityMainBinding, MainViewModel> implements IMainView, View.OnClickListener {
    private MainFragment mMainFragment;
    private SupplyHallFragment mSupplyHallFragment;

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

        mMainFragment = new MainFragment();
        mSupplyHallFragment = new SupplyHallFragment();

        FragmentUtils.switchFragment(this,R.id.frame_home,mSupplyHallFragment,mMainFragment);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.img_title_notice_clear:
                mLayoutTitleNoticeHome.setVisibility(View.GONE);
                break;*/
        }
    }
}