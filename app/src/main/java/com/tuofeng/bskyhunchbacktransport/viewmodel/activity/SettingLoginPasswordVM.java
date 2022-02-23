package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

 import com.tuofeng.bskyhunchbacktransport.in.ISettingLoginPasswordView;
import com.tuofeng.bskyhunchbacktransport.module.data.SettingLoginPasswordRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class SettingLoginPasswordVM extends BaseViewModel<ISettingLoginPasswordView, SettingLoginPasswordRepository> {

    private final String TAG = "SettingLoginPasswordVM";
    private String mData="";

    public SettingLoginPasswordVM(ISettingLoginPasswordView iv) {
        super(iv,new SettingLoginPasswordRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }
}