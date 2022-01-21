package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public abstract class BaseFragment<B extends ViewDataBinding,M extends BaseViewModel> extends Fragment implements IView {

    protected M mViewModel;
    protected B mDataBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutID = getLayoutID();
        mViewModel = getViewModel();
        mDataBinding = DataBindingUtil.inflate(inflater, layoutID, container, false);
        return mDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    abstract void initView();
    abstract int getLayoutID();

    abstract M getViewModel();

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }

}
