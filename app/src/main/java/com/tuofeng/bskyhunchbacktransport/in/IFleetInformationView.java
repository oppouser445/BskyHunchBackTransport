package com.tuofeng.bskyhunchbacktransport.in;

import com.tuofeng.bskyhunchbacktransport.base.IView;

public interface IFleetInformationView extends IView {

    void PreviousAction();

    void NextAction(int type);

    void saveSubmitReview();
}