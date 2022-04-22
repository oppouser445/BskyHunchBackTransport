package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseFragmentActivity<B extends ViewDataBinding, M extends BaseViewModel> extends FragmentActivity implements IView {

    protected M mViewModel;
    protected B mDataBinding;
    protected ImageView mToolbarBack;
    protected TextView mToolbarTitle;
    private String TAG = "BaseFragmentActivity";

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
        if (mViewModel != null) {
            mViewModel.onActivityDestroyed();
        }
        mViewModel = null;
        mDataBinding = null;
    }

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

    /**
     * 以license文件方式初始化
     */
    public void initAccessToken() {
        OCR.getInstance(getApplicationContext()).initAccessToken(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken accessToken) {
                String token = accessToken.getAccessToken();
                LogUtils.e(TAG, "licence方式获取token成功 " + token);
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
                LogUtils.e(TAG, "licence方式获取token失败 " + error.getMessage());
                /*alertText("licence方式获取token失败", error.getMessage());*/
            }
        }, getApplicationContext());
    }

}