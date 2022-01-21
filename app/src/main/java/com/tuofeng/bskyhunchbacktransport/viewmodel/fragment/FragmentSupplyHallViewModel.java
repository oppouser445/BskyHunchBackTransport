package com.tuofeng.bskyhunchbacktransport.viewmodel.fragment;

import com.tuofeng.bskyhunchbacktransport.in.ISupplyHallFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.data.FragmentSupplyHallRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class FragmentSupplyHallViewModel extends BaseViewModel<ISupplyHallFragmentView, FragmentSupplyHallRepository> {

    private final String TAG = "FragmentMainViewModel";

    public FragmentSupplyHallViewModel(ISupplyHallFragmentView iView) {
        super(iView, new FragmentSupplyHallRepository());
    }
}