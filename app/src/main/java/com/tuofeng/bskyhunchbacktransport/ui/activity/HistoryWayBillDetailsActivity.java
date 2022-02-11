package com.tuofeng.bskyhunchbacktransport.ui.activity;


import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityHistoryWayBillDetailsBinding;
import com.tuofeng.bskyhunchbacktransport.in.IHistoricalWayBillDetailsView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.HistoricalWaybillDetailsViewModel;

public class HistoryWayBillDetailsActivity extends BaseActivity<ActivityHistoryWayBillDetailsBinding, HistoricalWaybillDetailsViewModel> implements IHistoricalWayBillDetailsView {

    @Override
    protected HistoricalWaybillDetailsViewModel getViewModel() {
        return new HistoricalWaybillDetailsViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_history_way_bill_details;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("历史运单详情");
    }

    @Override
    protected void initData() {

    }
}