package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.module.adapter.PersonnelManagementAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class PersonnelManagementActivity extends BaseActivity {

    private RecyclerView mRecyclerList;
    private List<String> mDataList;
    private PersonnelManagementAdapter mAdapter;

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personnel_management;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("人员管理");
        mTvRightClick.setText("代收邀约");
        mTvRightClick.setVisibility(View.VISIBLE);

        mRecyclerList = findViewById(R.id.recycler_list);

        mDataList = new ArrayList<>();
        mAdapter = new PersonnelManagementAdapter(mDataList, this);
        mAdapter.setMyOnClickListener(new PersonnelManagementAdapter.MyOnClickListener() {
            @Override
            public void onItemClick(int position) {
                /*Intent intent = new Intent(PersonnelManagementActivity.this, DriverInformationDetailsActivity.class);
                startActivity(intent);*/

                Intent intent = new Intent(PersonnelManagementActivity.this, DriverInformation2Activity.class);
                startActivity(intent);
            }
        });

        mRecyclerList.setAdapter(mAdapter);

        mRecyclerList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {

    }
}