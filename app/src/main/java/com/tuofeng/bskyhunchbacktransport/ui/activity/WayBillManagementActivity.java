package com.tuofeng.bskyhunchbacktransport.ui.activity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityWaybillManagementBinding;
import com.tuofeng.bskyhunchbacktransport.in.IWayBillManagementView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.RecycleWayBillManagementLeftAdapter;
import com.tuofeng.bskyhunchbacktransport.module.adapter.RecycleWayBillManagementRightAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.WayBillManagementViewModel;

import java.util.ArrayList;
import java.util.List;

public class WayBillManagementActivity extends BaseFragmentActivity<ActivityWaybillManagementBinding, WayBillManagementViewModel> implements IWayBillManagementView {

    private RecyclerView mRecyclerDataLeft,mRecyclerDataRight;
    private List<String> mDataList;
    private RecycleWayBillManagementLeftAdapter mLeftAdapter;
    private RecycleWayBillManagementRightAdapter mRightAdapter;

    @Override
    protected WayBillManagementViewModel getViewModel() {
        return new WayBillManagementViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_waybill_management;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("安排/改派司机");

        mRecyclerDataLeft = mDataBinding.recyclerDataLeft;
        LinearLayoutManager mLayoutManagerLeft = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerDataLeft.setLayoutManager(mLayoutManagerLeft);

        mDataList = new ArrayList<>();
        mLeftAdapter = new RecycleWayBillManagementLeftAdapter(mDataList, this);
        mRecyclerDataLeft.setAdapter(mLeftAdapter);

        mLeftAdapter.setOnChildListener((view, position) -> {
        });

        mRecyclerDataRight = mDataBinding.recyclerDataRight;
        LinearLayoutManager mLayoutManagerRight = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerDataRight.setLayoutManager(mLayoutManagerRight);

        mRightAdapter = new RecycleWayBillManagementRightAdapter(mDataList, this);
        mRecyclerDataRight.setAdapter(mRightAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void confirmChanges() {
    }
}