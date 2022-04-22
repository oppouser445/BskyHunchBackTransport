package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.base.IView;
import com.tuofeng.bskyhunchbacktransport.module.bean.BaseBean;
import com.tuofeng.bskyhunchbacktransport.utils.AppSimplifyLogicUtil;
import com.tuofeng.bskyhunchbacktransport.utils.CommonUtil;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.utils.PermissionUtil;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public abstract class BaseActivity<B extends ViewDataBinding, M extends BaseViewModel> extends Activity implements IView, EasyPermissions.PermissionCallbacks {

    protected B mDataBinding;
    protected M mViewModel;
    protected ImageView mToolbarBack, mImageTitleRight;
    protected TextView mToolbarTitle, mTvRightClick;
    protected boolean pHasGotToken;
    private String TAG = "BaseActivity";
    private BaseBean baseBean;
    protected Context mContext;

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
        mTvRightClick = findViewById(R.id.tv_right_click);
        mImageTitleRight = findViewById(R.id.image_title_right);
    }

    protected void initStatusBar(int type) {
        if (type == 1) {
            StatusBarUtil.setTransparentStatusBar(getWindow(), 1);
        } else {
            StatusBarUtil.setTransparentStatusBar(getWindow());
        }
    }

    protected void onPermissionsGrantedChild(int requestCode, List<String> perms) {
    }

    protected void onPermissionsDeniedChild(int requestCode, List<String> perms) {
    }

    protected void publicCallback(BaseBean baseBean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (mViewModel != null) {
            mViewModel.onActivityDestroyed();
            mViewModel = null;
            mDataBinding = null;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    protected void onActivityResultCustomize(int requestCode, int resultCode, @Nullable Intent data) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onActivityResultCustomize(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        onPermissionsGrantedChild(requestCode, perms);
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        onPermissionsDeniedChild(requestCode, perms);
        processingAuthorizationData(perms);
    }

    private void processingAuthorizationData(List<String> perms) {
        String permissionString = perms.get(0);
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSimplifyLogicUtil.showRoundCornerDialog(mContext, "", PermissionUtil.getPermissionsHint(permissionString), "退出", "确定", () -> {
                CommonUtil.startSetting(this, PermissionUtil.getPermissionCode(permissionString));
            }, () -> {
                finish();
            });
        } else {
            getLocationPermission(permissionString);
        }
    }

    protected void getLocationPermission(String permissionsType) {
        if (baseBean == null) {
            baseBean = new BaseBean();
        }
        baseBean.setData(permissionsType);
        PermissionUtil.getPermissionList(this, permissionsType, type -> publicCallback(baseBean));
    }
}