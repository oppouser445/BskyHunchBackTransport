package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.module.adapter.HistoricalWayBillAdapter;
import com.tuofeng.bskyhunchbacktransport.module.adapter.VehicleManagementAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class VehicleManagementActivity extends BaseActivity {

    private RecyclerView mRecyclerList;
    private List<String> mDataList;
    private VehicleManagementAdapter mAdapter;

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vehicle_management;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mRecyclerList = findViewById(R.id.recycler_list);

        mDataList = new ArrayList<>();
        mAdapter = new VehicleManagementAdapter(mDataList,this);
        mRecyclerList.setAdapter(mAdapter);

        /*mHistoricalWayBillAdapter = new HistoricalWayBillAdapter(mDataList, this);
        mHistoricalWayBillAdapter.setMyOnClickListener(position -> {
            Intent intent = new Intent(mActivity, HistoryWayBillDetailsActivity.class);
            startActivity(intent);
        });

        mRecyclerData.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerData.setAdapter(mHistoricalWayBillAdapter);*/
    }

    @Override
    protected void initData() {

    }
}