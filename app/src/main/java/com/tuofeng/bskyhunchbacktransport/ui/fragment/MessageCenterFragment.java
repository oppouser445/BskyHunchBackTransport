package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.ui.activity.MainActivity;
import com.tuofeng.bskyhunchbacktransport.ui.activity.MessageCenterDetailsActivity;
import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMessageCenterBinding;
import com.tuofeng.bskyhunchbacktransport.in.IMessageCenterFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.RecycleMessageCenterAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.MessageCenterFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MessageCenterFragment extends BaseFragment<FragmentMessageCenterBinding, MessageCenterFragmentViewModel> implements IMessageCenterFragmentView {

    private RecyclerView mRecyclerMessageCenter;
    private List<String> mDataList;
    private RecycleMessageCenterAdapter mRecycleAdapter;

    @Override
    int getLayoutID() {
        return R.layout.fragment_message_center;
    }

    @Override
    MessageCenterFragmentViewModel getViewModel() {
        return new MessageCenterFragmentViewModel(this);
    }

    @Override
    void initView() {
        mActivity = (MainActivity) getActivity();
        initTitleBar();
        mToolbarBack.setVisibility(View.GONE);
        mToolbarTitle.setText("消息中心");
        mRecyclerMessageCenter = mDataBinding.recyclerMessageCenter;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        //mRecyclerActHome.setNestedScrollingEnabled(false);
        mRecyclerMessageCenter.setLayoutManager(mLayoutManager);

        mDataList = new ArrayList<>();
        mRecycleAdapter = new RecycleMessageCenterAdapter(mDataList, mActivity);
        mRecyclerMessageCenter.setAdapter(mRecycleAdapter);

        mRecycleAdapter.setOnChildListener((view, position) -> {
            Intent intent = new Intent(mActivity, MessageCenterDetailsActivity.class);
            mActivity.startActivity(intent );
        });
    }

    @Override
    void initData() {

    }

}