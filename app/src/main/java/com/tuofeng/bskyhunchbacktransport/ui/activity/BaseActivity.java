package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity<B extends ViewDataBinding, M extends BaseViewModel> extends Activity implements IView {

    protected B mDataBinding;
    protected M mViewModel;
    protected ImageView mToolbarBack;
    protected TextView mToolbarTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setContentView(layoutId);

        StatusBarUtil.setLightStatusBar(this, true);

        mViewModel = getViewModel();
        mDataBinding = DataBindingUtil.setContentView(this, layoutId);
        initView();
        initData();
    }

    protected abstract M getViewModel();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    protected void initTitleBar() {
        initTitleBar(1);
    }

    protected void initTitleBar(int type) {
        initTitleBarBean();
        initStatusBar(type);
    }

    protected void initTitleBarBean() {
        mToolbarBack = findViewById(R.id.toolbar_back);
        mToolbarBack.setOnClickListener(v -> finish());
        mToolbarTitle = findViewById(R.id.toolbar_title);
    }

    protected void initStatusBar(int type) {
        if (type == 1) {
            StatusBarUtil.setTransparentStatusBar(getWindow(), 1);
        } else {
            StatusBarUtil.setTransparentStatusBar(getWindow());
        }
    }

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