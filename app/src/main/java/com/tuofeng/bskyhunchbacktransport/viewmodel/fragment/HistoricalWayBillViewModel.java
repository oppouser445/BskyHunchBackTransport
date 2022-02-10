package com.tuofeng.bskyhunchbacktransport.viewmodel.fragment;

import com.tuofeng.bskyhunchbacktransport.in.IHistoricalWayBillFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.data.HistoricalWaybillRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class HistoricalWayBillViewModel extends BaseViewModel<IHistoricalWayBillFragmentView, HistoricalWaybillRepository> {

    private final String TAG = "HistoricalWayBillViewModel";

    public HistoricalWayBillViewModel(IHistoricalWayBillFragmentView iView) {
        super(iView, new HistoricalWaybillRepository());
    }
}