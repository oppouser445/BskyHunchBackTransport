package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityFleetManagementBinding;
import com.tuofeng.bskyhunchbacktransport.in.IFleetManagementV;
import com.tuofeng.bskyhunchbacktransport.module.adapter.ApplyJoinTeamAdapter;
import com.tuofeng.bskyhunchbacktransport.module.adapter.FleetManagementAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.FleetManagementVM;

import java.util.ArrayList;
import java.util.List;

public class FleetManagementActivity extends BaseActivity<ActivityFleetManagementBinding, FleetManagementVM> implements IFleetManagementV, View.OnClickListener {


    private List<String> mDataList, mDataList2;
    private FleetManagementAdapter mRecycleAdapter;
    private ApplyJoinTeamAdapter mRecycleAdapter2;
    private RecyclerView mRecyclerList1, mRecyclerList2;
    private RelativeLayout mRLyaoutAllMembers, mRLyaoutApplyJoinTeam;
    private ImageView mImageRightIcon1, mImageRightIcon2;

    @Override
    protected FleetManagementVM getViewModel() {
        return new FleetManagementVM(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fleet_management;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("我的车队");
        mDataBinding.setViewModel(mViewModel);
        mImageTitleRight.setVisibility(View.VISIBLE);
        mImageTitleRight.setOnClickListener(this);

        mRecyclerList1 = mDataBinding.recyclerList1;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //mRecyclerActHome.setNestedScrollingEnabled(false);
        mRecyclerList1.setLayoutManager(mLayoutManager);

        mDataList = new ArrayList<>();
        mRecycleAdapter = new FleetManagementAdapter(mDataList, this);
        mRecyclerList1.setAdapter(mRecycleAdapter);
        mRecyclerList1.setVisibility(View.VISIBLE);

        mRecyclerList2 = mDataBinding.recyclerList2;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //mRecyclerActHome.setNestedScrollingEnabled(false);
        mRecyclerList2.setLayoutManager(layoutManager);

        mDataList2 = new ArrayList<>();
        mRecycleAdapter2 = new ApplyJoinTeamAdapter(mDataList2, this);
        mRecyclerList2.setAdapter(mRecycleAdapter2);
        mRecyclerList2.setVisibility(View.GONE);

        mRLyaoutAllMembers = mDataBinding.rLyaoutAllMembers;
        mRLyaoutAllMembers.setOnClickListener(this);
        mRLyaoutApplyJoinTeam = mDataBinding.rLyaoutApplyJoinTeam;
        mRLyaoutApplyJoinTeam.setOnClickListener(this);

        mImageRightIcon1 = mDataBinding.imageRightIcon1;
        mImageRightIcon2 = mDataBinding.imageRightIcon2;
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_title_right:
                Intent intent = new Intent(FleetManagementActivity.this, AddFleetActivity.class);
                startActivity(intent);
                break;
            case R.id.rLyaout_all_members:
                setLayoutStyle(1);
                break;
            case R.id.rLyaout_apply_join_team:
                setLayoutStyle(2);
                break;
        }
    }

    private void setLayoutStyle(int layoutStyle) {
        mRecyclerList1.setVisibility(layoutStyle == 1 ? View.VISIBLE : View.GONE);
        mRecyclerList2.setVisibility(layoutStyle == 2 ? View.VISIBLE : View.GONE);

        mRLyaoutAllMembers.setBackgroundResource(layoutStyle == 1 ? R.drawable.shape_fleet_management_tab1_bg : R.drawable.shape_fleet_management_tab2_bg);
        mRLyaoutApplyJoinTeam.setBackgroundResource(layoutStyle == 2 ? R.drawable.shape_fleet_management_tab1_bg : R.drawable.shape_fleet_management_tab2_bg);

        mImageRightIcon1.setVisibility(layoutStyle == 1 ? View.VISIBLE : View.GONE);
        mImageRightIcon2.setVisibility(layoutStyle == 2 ? View.VISIBLE : View.GONE);
    }
}