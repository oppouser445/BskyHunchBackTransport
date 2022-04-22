package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivitySplashBinding;
import com.tuofeng.bskyhunchbacktransport.in.ISplashView;
import com.tuofeng.bskyhunchbacktransport.module.bean.BaseBean;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.utils.PermissionUtil;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;
import com.tuofeng.bskyhunchbacktransport.utils.UserSPUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.SplashViewModel;

import java.util.List;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> implements ISplashView {

    private String TAG = "SplashActivity";

    @Override
    protected SplashViewModel getViewModel() {
        return new SplashViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mContext = this;
        StatusBarUtil.setTransparentStatusBar(getWindow(),2);
        mDataBinding.setViewModel(mViewModel);
        getLocationPermission(PermissionUtil.ACCESS_FINE_LOCATION);
    }

    @Override
    protected void initData() {
        mViewModel.getUserData();
    }

    @Override
    protected void onActivityResultCustomize(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PermissionUtil.ACCESS_FINE_LOCATION_CODE) {//设置页返回处理
            getLocationPermission(PermissionUtil.ACCESS_FINE_LOCATION);
        } else if (requestCode == PermissionUtil.CALL_PHONE_CODE) {
            getLocationPermission(PermissionUtil.CALL_PHONE);
        } else if (requestCode == PermissionUtil.READ_EXTERNAL_STORAGE_COD) {
            getLocationPermission(PermissionUtil.READ_EXTERNAL_STORAGE);
        }
    }

    @Override
    public void startLoginAct() {
        //Intent intent = new Intent(this,MainActivity.class);
        /*Intent intent =null;
        String userToken = UserSPUtil.getUserToken();
        if (!TextUtils.isEmpty(userToken)) {
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();*/
    }

    @Override
    protected void onPermissionsGrantedChild(int requestCode, List<String> perms) {
        super.onPermissionsGrantedChild(requestCode, perms);
        PermissionRequestProcessing(perms.get(0));
    }

    @Override
    public void publicCallback(BaseBean baseBean) {
        String permissionsType = (String) baseBean.getData();
        PermissionRequestProcessing(permissionsType);
    }

    public void startLoginAct2(){
        Intent intent =null;
        String userToken = UserSPUtil.getUserToken();
        if (!TextUtils.isEmpty(userToken)) {
            intent = new Intent(this, MainActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }

    private void PermissionRequestProcessing(String permissionsType) {
        if (PermissionUtil.ACCESS_FINE_LOCATION.equals(permissionsType)) {
            getLocationPermission(PermissionUtil.CALL_PHONE);
        } else if (PermissionUtil.CALL_PHONE.equals(permissionsType)) {
            getLocationPermission(PermissionUtil.READ_EXTERNAL_STORAGE);
        } else if (PermissionUtil.READ_EXTERNAL_STORAGE.equals(permissionsType)) {
            startLoginAct2();
        }
    }
}