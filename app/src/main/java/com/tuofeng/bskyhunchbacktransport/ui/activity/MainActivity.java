package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.in.IMainView;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.BaseFragment;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.MainFragment;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.MessageCenterFragment;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.MineFragment;
import com.tuofeng.bskyhunchbacktransport.ui.fragment.SupplyHallFragment;
import com.tuofeng.bskyhunchbacktransport.utils.FragmentUtils;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.MainViewModel;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityMainBinding;

public class MainActivity extends BaseFragmentActivity<ActivityMainBinding, MainViewModel> implements IMainView, View.OnClickListener {
    private MainFragment mMainFragment;
    private SupplyHallFragment mSupplyHallFragment;
    private MessageCenterFragment mMessageCenterFragment;
    private MineFragment mMineFragment;
    private LinearLayout mLlayoutMain, mLlayoutMainHome, mLlayoutSupplyHall, mLlayoutTask,mLlayoutMessage, mlLayoutMine;
    private BaseFragment mTheCurrentpage;

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
        FragmentUtils.initFragment(this, R.id.frame_home, mMainFragment);
        mTheCurrentpage = mMainFragment;

        mLlayoutMain = mDataBinding.lLayoutMainHome;

        mLlayoutMainHome = mDataBinding.lLayoutMain;
        mLlayoutMainHome.setOnClickListener(this);

        mLlayoutSupplyHall = mDataBinding.lLayoutSupplyHall;
        mLlayoutSupplyHall.setOnClickListener(this);

        mLlayoutTask = mDataBinding.lLayoutTask;
        mLlayoutTask.setOnClickListener(this);

        mLlayoutMessage = mDataBinding.lLayoutMessage;
        mLlayoutMessage.setOnClickListener(this);

        mlLayoutMine = mDataBinding.lLayoutMine;
        mlLayoutMine.setOnClickListener(this);

        setBottomViewStyle(0);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lLayout_main:
                toggleFragment(0);
                break;
            case R.id.lLayout_supply_hall:
                toggleFragment(1);
                break;
            case R.id.lLayout_task:
                break;
            case R.id.lLayout_message:
                toggleFragment(3);
                break;
            case R.id.lLayout_mine:
                toggleFragment(4);
                break;
        }
    }

    private void toggleFragment(int type) {
        int titleBarColor = 0;
        BaseFragment fragment = null;
        if (type == 0) {
            if (mMainFragment == null) {
                mMainFragment = new MainFragment();
            }
            fragment = mMainFragment;
            titleBarColor = 1;
        }
        if (type == 1) {
            if (mSupplyHallFragment == null) {
                mSupplyHallFragment = new SupplyHallFragment();
            }
            fragment = mSupplyHallFragment;
            titleBarColor = 1;
        }else if (type == 3) {
            if (mMessageCenterFragment == null) {
                mMessageCenterFragment = new MessageCenterFragment();
            }
            titleBarColor = 1;
            fragment = mMessageCenterFragment;
        } else if (type == 4) {
            if (mMineFragment == null) {
                mMineFragment = new MineFragment();
            }
            titleBarColor = 2;
            fragment = mMineFragment;
        }
        FragmentUtils.switchFragment(this, R.id.frame_home, mTheCurrentpage, fragment);
        StatusBarUtil.setTransparentStatusBar(getWindow(), titleBarColor);
        setBottomViewStyle(type);
        mTheCurrentpage = fragment;
    }

    private void setBottomViewStyle(int type) {
        int childCount = mLlayoutMain.getChildCount();
        for (int i = 0; i < childCount; i++) {
            LinearLayout childAt = (LinearLayout) mLlayoutMain.getChildAt(i);
            TextView tv1 = (TextView) childAt.getChildAt(0);
            TextView tv2 = (TextView) childAt.getChildAt(1);
            tv1.setEnabled(i == type);
            tv2.setTextColor(getResources().getColor(i == type ? R.color.color_main_orange : R.color.fragment_main_bottom_tv_color));
        }
    }
}