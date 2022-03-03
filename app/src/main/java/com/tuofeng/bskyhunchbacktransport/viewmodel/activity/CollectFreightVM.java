package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.ICollectFreightView;
import com.tuofeng.bskyhunchbacktransport.module.data.CollectFreightRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class CollectFreightVM extends BaseViewModel<ICollectFreightView, CollectFreightRepository> {

    private final String TAG = "CollectFreightVM";
    private String mData="";

    public CollectFreightVM(ICollectFreightView iv) {
        super(iv,new CollectFreightRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }
}