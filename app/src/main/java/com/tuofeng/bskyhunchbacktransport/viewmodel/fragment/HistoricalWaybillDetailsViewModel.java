package com.tuofeng.bskyhunchbacktransport.viewmodel.fragment;

import com.tuofeng.bskyhunchbacktransport.in.IHistoricalWayBillDetailsView;
import com.tuofeng.bskyhunchbacktransport.module.data.HistoricalWaybillDetailsRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class HistoricalWaybillDetailsViewModel extends BaseViewModel<IHistoricalWayBillDetailsView, HistoricalWaybillDetailsRepository> {

    private final String TAG = "HistoricalWayBillViewModel";

    public HistoricalWaybillDetailsViewModel(IHistoricalWayBillDetailsView iView) {
        super(iView, new HistoricalWaybillDetailsRepository());
    }
}