package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity<B extends ViewDataBinding,M extends BaseViewModel> extends Activity implements IView {

    protected M mViewModel;
    protected B mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setContentView(layoutId);

        StatusBarUtil.setLightStatusBar(this, true);
        StatusBarUtil.setTransparentStatusBar(getWindow());

        mViewModel = getViewModel();
        mDataBinding = DataBindingUtil.setContentView(this, layoutId);
        initView();
        initData();
    }

    protected abstract M getViewModel();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }
}