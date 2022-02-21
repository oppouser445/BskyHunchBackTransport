package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityBankCardBinding;
import com.tuofeng.bskyhunchbacktransport.in.IBankCardView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.BankCardAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.BankCardViewModel;

import java.util.ArrayList;
import java.util.List;

public class BankCardActivity extends BaseActivity<ActivityBankCardBinding, BankCardViewModel> implements IBankCardView {

    private RecyclerView mRecyclerList;
    private List<String> mList;
    private LinearLayout mLlyaoutAddBankCard;

    @Override
    protected BankCardViewModel getViewModel() {
        return new BankCardViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mDataBinding.setViewModel(mViewModel);
        mToolbarTitle.setText("银行卡");

        mRecyclerList = mDataBinding.recyclerList;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerList.setLayoutManager(mLayoutManager);

        mList = new ArrayList<>();
        BankCardAdapter adapter = new BankCardAdapter(mList,this);
        mRecyclerList.setAdapter(adapter);

        mLlyaoutAddBankCard = mDataBinding.lLyaoutAddBankCard;
        mLlyaoutAddBankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BankCardActivity.this,AddBankCardProcessActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }
}