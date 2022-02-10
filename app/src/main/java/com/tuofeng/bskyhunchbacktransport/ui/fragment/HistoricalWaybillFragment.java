package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.HistoricalWaybillFragmentLayoutBinding;
import com.tuofeng.bskyhunchbacktransport.in.IHistoricalWayBillFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.HistoricalWayBillAdapter;
import com.tuofeng.bskyhunchbacktransport.ui.activity.HistoryWayBillDetailsActivity;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.HistoricalWayBillViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoricalWaybillFragment extends BaseFragment<HistoricalWaybillFragmentLayoutBinding, HistoricalWayBillViewModel> implements IHistoricalWayBillFragmentView {

    private String mFragmentType;
    private RecyclerView mRecyclerData;
    private List<String> dataList;
    private HistoricalWayBillAdapter mHistoricalWayBillAdapter;

    @Override
    int getLayoutID() {
        return R.layout.historical_waybill_fragment_layout;
    }

    @Override
    HistoricalWayBillViewModel getViewModel() {
        return new HistoricalWayBillViewModel(this);
    }

    @Override
    void initView() {
        if (getArguments() != null) {
            mFragmentType = getArguments().getString("position");
        }
        mActivity = (Activity) getContext();
        mRecyclerData = mDataBinding.recyclerData;
        dataList = new ArrayList<>();
        mHistoricalWayBillAdapter = new HistoricalWayBillAdapter(dataList, mActivity);
        mHistoricalWayBillAdapter.setMyOnClickListener(position -> {
            Intent intent = new Intent(mActivity, HistoryWayBillDetailsActivity.class);
            startActivity(intent);
        });

        mRecyclerData.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerData.setAdapter(mHistoricalWayBillAdapter);
    }

    @Override
    void initData() {

    }

    public static HistoricalWaybillFragment newInstance(String param1) {
        HistoricalWaybillFragment fragment = new HistoricalWaybillFragment();
        Bundle args = new Bundle();
        args.putString("position", param1);
        fragment.setArguments(args);
        return fragment;
    }
}