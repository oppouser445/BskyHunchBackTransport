package com.tuofeng.bskyhunchbacktransport.viewmodel.fragment;

import com.tuofeng.bskyhunchbacktransport.in.IMainFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.data.FragmentMainRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class FragmentMainViewModel extends BaseViewModel<IMainFragmentView, FragmentMainRepository> {

    private final String TAG = "FragmentMainViewModel";

    public FragmentMainViewModel(IMainFragmentView iView) {
        super(iView, new FragmentMainRepository());
    }
}