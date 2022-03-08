package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityCollectFreightBinding;
import com.tuofeng.bskyhunchbacktransport.in.ICollectFreightView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.CollectFreightVM;
import com.tuofeng.bskyhunchbacktransport.module.adapter.CollectFreightAdapter;

import java.util.ArrayList;
import java.util.List;

public class CollectFreightActivity extends BaseActivity<ActivityCollectFreightBinding, CollectFreightVM> implements ICollectFreightView {

    private List<String> mDataList;
    private CollectFreightAdapter mAdapter;
    private RecyclerView mRecyclerList;

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
        mDataBinding.setViewModel(mViewModel);

        mToolbarTitle.setText("代收运费");
        mTvRightClick.setText("代收邀约");
        mTvRightClick.setVisibility(View.VISIBLE);

        mDataList = new ArrayList<>();
        mAdapter = new CollectFreightAdapter(mDataList, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerList = mDataBinding.recyclerList;
        mRecyclerList.setLayoutManager(manager);
        mRecyclerList.setAdapter(mAdapter);
        /*
        mRecyclerList.setLayoutManager(new LinearLayoutManager(this));*/
    }

    @Override
    protected void initData() {

    }
}