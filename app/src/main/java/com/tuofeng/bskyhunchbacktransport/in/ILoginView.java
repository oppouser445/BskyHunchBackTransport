package com.tuofeng.bskyhunchbacktransport.in;

import com.tuofeng.bskyhunchbacktransport.base.IView;

public interface ILoginView extends IView {
    void loginUser(int type);
    void getMobileVerificationCode();

    void showLoginView(int type);
}
