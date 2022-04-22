package com.tuofeng.bskyhunchbacktransport.contract;

import com.tuofeng.bskyhunchbacktransport.base.IView;


public class LoginContract {
    public interface ILoginView extends IView {
        void loginUser(int type);
        void getMobileVerificationCode();
        void showLoginView(int type);
        void startHomeActivity();
    }

    public interface ILoginRepository {
        void startHomeActivity();
    }
}
