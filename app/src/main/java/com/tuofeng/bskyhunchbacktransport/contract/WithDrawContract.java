package com.tuofeng.bskyhunchbacktransport.contract;

import com.tuofeng.bskyhunchbacktransport.base.IView;


public class WithDrawContract {
    public interface IWithDrawView extends IView {
        void withDrawOnclick();
    }

    public interface IWithDrawRepository {
        void withDrawOnclick();
    }
}
