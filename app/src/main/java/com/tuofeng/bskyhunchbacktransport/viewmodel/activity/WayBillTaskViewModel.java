package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import com.tuofeng.bskyhunchbacktransport.in.IWayBillTaskView;
import com.tuofeng.bskyhunchbacktransport.module.data.WayBillTaskRepository;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class WayBillTaskViewModel extends BaseViewModel<IWayBillTaskView, WayBillTaskRepository> {

    private final String TAG = "WayBillTaskViewModel";
    private String mData = "";

    private int testData = 0;

    public WayBillTaskViewModel(IWayBillTaskView iv) {
        super(iv, new WayBillTaskRepository());
    }

    public void startSupplyHallAct() {
        mIView.startSupplyHallAct();
        LogUtils.e(TAG, "testData == " + testData);
    }
}