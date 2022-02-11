package com.tuofeng.bskyhunchbacktransport.viewmodel.fragment;

import com.tuofeng.bskyhunchbacktransport.in.IMineFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.data.MineFragmentRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class MineFragmentViewModel extends BaseViewModel<IMineFragmentView, MineFragmentRepository> {

    private final String TAG = "FragmentMainViewModel";

    public MineFragmentViewModel(IMineFragmentView iView) {
        super(iView, new MineFragmentRepository());
    }

    public void startHistoricalWayBillActivity(){
        mIView.startHistoricalWayBillActivity();
    }

}