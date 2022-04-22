package com.tuofeng.bskyhunchbacktransport.viewmodel;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.tuofeng.bskyhunchbacktransport.contract.LoginContract;
import com.tuofeng.bskyhunchbacktransport.module.bean.UserBean;
import com.tuofeng.bskyhunchbacktransport.module.data.LoginRepository;
import com.tuofeng.bskyhunchbacktransport.utils.UserSPUtil;
import com.tuofeng.bskyhunchbacktransport.utils.retrofit.Config;

public class LoginViewModel extends BaseViewModel<LoginContract.ILoginView, LoginRepository> {

    private final String TAG = "SplashViewModel";
    private String mData = "";

    public ObservableField<UserBean> userBean = new ObservableField<>();

    public LoginViewModel(LoginContract.ILoginView iv) {
        super(iv, new LoginRepository());
        UserBean bean = new UserBean();
        userBean.set(bean);
    }

    @Bindable
    public String getTestData() {
        return mData;
    }

    public void getMobileVerificationCode() {
        mIView.getMobileVerificationCode();
    }

    public void showLoginView(int type) {
        UserSPUtil.setUserTenant(type);
        mIView.showLoginView(type);
    }

    public void loginUser(int type) {
        UserBean bean = userBean.get();
        if (type == 4) {
            mDataSource.loginUser(bean, Config.gPhonePwdUrl, () -> {
                mIView.startHomeActivity();
            });
        } else {
            mIView.loginUser(type);
        }
    }
}