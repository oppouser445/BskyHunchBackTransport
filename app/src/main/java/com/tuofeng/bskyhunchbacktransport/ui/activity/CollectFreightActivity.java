package com.tuofeng.bskyhunchbacktransport.ui.activity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.in.ICollectFreightView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.CollectFreightVM;
import com.tuofeng.bskyhunchbacktransport.module.adapter.CollectFreightAdapter;

import java.util.ArrayList;
import java.util.List;

public class CollectFreightActivity extends BaseActivity implements ICollectFreightView {

    private List<String> mDataList;
    private CollectFreightAdapter mAdapter;

    @Override
    protected CollectFreightVM getViewModel() {
        return new CollectFreightVM(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect_freight;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("代收运费");
        mTvRightClick.setText("代收邀约");

        mDataList = new ArrayList<>();
        mAdapter = new CollectFreightAdapter(mDataList, this);
        /*
        mRecyclerList.setLayoutManager(new LinearLayoutManager(this));*/
    }

    @Override
    protected void initData() {

    }
}