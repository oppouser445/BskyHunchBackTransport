package com.tuofeng.bskyhunchbacktransport.ui.activity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class CommentsComplaintsActivity extends BaseActivity {

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_comments_complaints;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("意见与投诉");
    }

    @Override
    protected void initData() {

    }
}