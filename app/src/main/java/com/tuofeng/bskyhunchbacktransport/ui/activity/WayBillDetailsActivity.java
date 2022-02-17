package com.tuofeng.bskyhunchbacktransport.ui.activity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityWayBillDetailsBinding;
import com.tuofeng.bskyhunchbacktransport.in.IWayBillDetailsView;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.WayBillDetailsViewModel;

public class WayBillDetailsActivity extends BaseActivity<ActivityWayBillDetailsBinding, WayBillDetailsViewModel> implements IWayBillDetailsView {

    private SharedButton btnStartNavigating;

    @Override
    protected WayBillDetailsViewModel getViewModel() {
        return new WayBillDetailsViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_way_bill_details;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("运单详情");
        btnStartNavigating = mDataBinding.btnStartNavigating;
    }

    @Override
    protected void initData() {

    }
}