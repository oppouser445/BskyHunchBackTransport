package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.module.adapter.SubscribeRouteAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class SubscribeRouteActivity extends BaseActivity {

    private List<String> mDataList;
    private RecyclerView mRecyclerList;
    private SubscribeRouteAdapter mSubscribeRouteAdapter;

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_subscribe_route;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("订阅路线");
        mRecyclerList = findViewById(R.id.recycler_list);
        mDataList = new ArrayList<String>();
        mSubscribeRouteAdapter = new SubscribeRouteAdapter(mDataList, this);
        mSubscribeRouteAdapter.setMyOnClickListener(position -> {
            Intent intent = new Intent(this, HistoryWayBillDetailsActivity.class);
            startActivity(intent);
        });
        mRecyclerList.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerList.setAdapter(mSubscribeRouteAdapter);
    }

    @Override
    protected void initData() {

    }
}
