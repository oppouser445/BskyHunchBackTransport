package com.tuofeng.bskyhunchbacktransport.viewmodel.fragment;

import com.tuofeng.bskyhunchbacktransport.in.IMessageCenterFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.data.MessageCenterFragmentRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class MessageCenterFragmentViewModel extends BaseViewModel<IMessageCenterFragmentView, MessageCenterFragmentRepository> {

    private final String TAG = "FragmentMainViewModel";

    public MessageCenterFragmentViewModel(IMessageCenterFragmentView iView) {
        super(iView, new MessageCenterFragmentRepository());
    }
}