package com.tuofeng.bskyhunchbacktransport.viewmodel;

import androidx.databinding.BaseObservable;

import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.in.BaseDataSource;

public class BaseViewModel<V extends IView,T extends BaseDataSource>  extends BaseObservable {

    protected V mIView;
    protected T mDataSource;

    public BaseViewModel(V v,T dataSource) {
        this.mIView = v;
        this.mDataSource = dataSource;
    }

    public void onActivityDestroyed(){
        mIView = null;
        mDataSource = null;
    }
}