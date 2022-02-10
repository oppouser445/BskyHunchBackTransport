package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.ui.activity.MainActivity;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public abstract class BaseFragment<B extends ViewDataBinding,M extends BaseViewModel> extends Fragment implements IView {

    protected M mViewModel;
    protected B mDataBinding;
    protected ImageView mToolbarBack;
    protected TextView mToolbarTitle;
    Activity mActivity;

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
        initData();
    }

    abstract void initView();
    abstract void initData();
    abstract int getLayoutID();

    abstract M getViewModel();

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    protected void initTitleBar() {
        initTitleBar(1);
    }

    protected void initTitleBar(int type) {
        initTitleBarBean();
        initStatusBar(type);
    }

    protected void initTitleBarBean() {
        mToolbarBack = mActivity.findViewById(R.id.toolbar_back);
        mToolbarBack.setOnClickListener(v -> mActivity.finish());
        mToolbarTitle = mActivity.findViewById(R.id.toolbar_title);
    }

    protected void initStatusBar(int type) {
        if (type == 1) {
            StatusBarUtil.setTransparentStatusBar(mActivity.getWindow(), 1);
        } else {
            StatusBarUtil.setTransparentStatusBar(mActivity.getWindow());
        }
    }

}
