
package com.tuofeng.bskyhunchbacktransport.ui.activity;


import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityWayBillTaskBinding;
import com.tuofeng.bskyhunchbacktransport.in.IWayBillTaskView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.WayBillTaskAdapter;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.LoadingDepartureDialog;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.WayBillPhoneDialog;
import com.tuofeng.bskyhunchbacktransport.utils.CommonUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.WayBillTaskViewModel;

import java.util.ArrayList;
import java.util.List;

public class WayBillTaskActivity extends BaseActivity<ActivityWayBillTaskBinding, WayBillTaskViewModel> implements IWayBillTaskView {

    private List<String> mDataList;
    private WayBillTaskAdapter mRecycleAdapter;
    private RecyclerView mRecyclerList;

    @Override
    protected WayBillTaskViewModel getViewModel() {
        return new WayBillTaskViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_way_bill_task;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("运单任务");
        mTvRightClick.setText("历史运单");
        mTvRightClick.setVisibility(View.GONE);

        mRecyclerList = mDataBinding.recyclerList;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerList.setLayoutManager(mLayoutManager);
        mDataList = new ArrayList<>();
        mRecycleAdapter = new WayBillTaskAdapter(mDataList, this);
        mRecyclerList.setAdapter(mRecycleAdapter);
        mRecycleAdapter.setMyOnClickListener((type, position) -> {
            if (type == 1) {
                WayBillPhoneDialog wayBillPhoneDialog = new WayBillPhoneDialog(this);
                wayBillPhoneDialog.setMyClickListener(phone -> CommonUtil.callPhone(WayBillTaskActivity.this, phone));
                wayBillPhoneDialog.show();
            } else if (type == 2) {
                LoadingDepartureDialog departureDialog = new LoadingDepartureDialog(this);
                departureDialog.setMyClickListener(data -> {

                });
                departureDialog.show();
            } else if (type == 3) {
                Intent intent = new Intent(this, WayBillDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void startSupplyHallAct() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
