
package com.tuofeng.bskyhunchbacktransport.ui.activity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityWayBillTaskBinding;
import com.tuofeng.bskyhunchbacktransport.in.IWayBillTaskView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.WayBillTaskAdapter;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.WayBillPhoneDialog;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;
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
        mTvRghtClick.setText("历史运单");

        mRecyclerList = mDataBinding.recyclerList;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerList.setLayoutManager(mLayoutManager);
        mDataList = new ArrayList<>();
        mRecycleAdapter = new WayBillTaskAdapter(mDataList, this);
        mRecyclerList.setAdapter(mRecycleAdapter);
        mRecycleAdapter.setMyOnClickListener((type, position) -> {
            if (type == 1) {
                WayBillPhoneDialog wayBillPhoneDialog = new WayBillPhoneDialog(this);
                wayBillPhoneDialog.setMyClickListener(new WayBillPhoneDialog.MyClicklListener() {
                    @Override
                    public void onClick(String phone) {
                        ToastUtil.shortToast("点击手机按钮" + phone);
                    }
                });
                wayBillPhoneDialog.show();
            }
            //ToastUtil.shortToast(type == 1 ? "第一个" : "第二个");
        });
    }

    @Override
    protected void initData() {

    }
}
