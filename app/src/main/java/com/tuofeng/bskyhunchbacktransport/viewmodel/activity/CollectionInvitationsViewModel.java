package com.tuofeng.bskyhunchbacktransport.viewmodel.activity;

import androidx.databinding.Bindable;

import com.tuofeng.bskyhunchbacktransport.in.ICollectionInvitationsView;
import com.tuofeng.bskyhunchbacktransport.in.IMyPurseView;
import com.tuofeng.bskyhunchbacktransport.module.data.CollectionInvitationsRepository;
import com.tuofeng.bskyhunchbacktransport.module.data.MyPurseRepository;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class CollectionInvitationsViewModel extends BaseViewModel<ICollectionInvitationsView, CollectionInvitationsRepository> {

    private final String TAG = "CollectionInvitationsViewModel";
    private String mData = "";

    public CollectionInvitationsViewModel(ICollectionInvitationsView iv) {
        super(iv, new CollectionInvitationsRepository());
    }

    @Bindable
    public String getTestData() {
        return mData;
    }

    public void agreeCollect() {
        mIView.agreeCollect();
    }

    public void refuseCollect() {
        mIView.refuseCollect();
    }
}