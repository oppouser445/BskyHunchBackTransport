package com.tuofeng.bskyhunchbacktransport.viewmodel;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.ILoginView;
import com.tuofeng.bskyhunchbacktransport.mode.data.LoginRepository;

public class LoginViewModel extends BaseViewModel<ILoginView, LoginRepository>{

    private final String TAG = "SplashViewModel";
    private String mData="";

    public LoginViewModel(ILoginView iv) {
        super(iv,new LoginRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }

    public void getMobileVerificationCode() {
        mIView.getMobileVerificationCode();
    }

    public void showLoginView(int type){
        mIView.showLoginView(type);
    }

    public void loginUser(int type) {
        if(type == 4){
            mDataSource.loginUser("https://www.baidu.com/", baseBean -> {
                mIView.loginUser(type);
            }, baseBean -> {

            });
        }else {
            mIView.loginUser(type);
        }
    }
}