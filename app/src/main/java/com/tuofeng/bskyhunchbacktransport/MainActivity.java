package com.tuofeng.bskyhunchbacktransport;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tuofeng.bskyhunchbacktransport.in.IMainView;
import com.tuofeng.bskyhunchbacktransport.ui.activity.BaseActivity;
import com.tuofeng.bskyhunchbacktransport.viewmodel.MainViewModel;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> implements IMainView, View.OnClickListener {

    private ImageView mImgTitleNoticeClear;
    private RelativeLayout mLayoutTitleNoticeHome;

    @Override
    protected MainViewModel getViewModel() {
        return new MainViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {//img_title_notice_clear
        mImgTitleNoticeClear = mDataBinding.imgTitleNoticeClear;
        mImgTitleNoticeClear.setOnClickListener(this);

        //rlayout_title_notice_home
        mLayoutTitleNoticeHome = mDataBinding.rlayoutTitleNoticeHome;

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