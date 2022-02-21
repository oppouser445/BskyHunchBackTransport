package com.tuofeng.bskyhunchbacktransport.ui.activity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityCollectionInvitationsBinding;
import com.tuofeng.bskyhunchbacktransport.in.ICollectionInvitationsView;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.CollectionInvitationsDialog;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.CollectionInvitationsViewModel;

public class CollectionInvitationsActivity extends BaseActivity<ActivityCollectionInvitationsBinding, CollectionInvitationsViewModel> implements ICollectionInvitationsView {


    private CollectionInvitationsDialog dialog;

    @Override
    protected CollectionInvitationsViewModel getViewModel() {
        return new CollectionInvitationsViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection_invitations;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mDataBinding.setViewModel(mViewModel);
        mToolbarTitle.setText("代收邀约");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void agreeCollect() {
        dialog = new CollectionInvitationsDialog(this);
        dialog.setmStyle(1);
        dialog.show();
        ToastUtil.showCenterToast(this,"同意代收前，请阅读并同意代收协议");
        //finish();
    }

    @Override
    public void refuseCollect() {
        dialog = new CollectionInvitationsDialog(this);
        dialog.setmStyle(2);
        dialog.show();
        ToastUtil.showCenterToast(this,"同意代收前，请阅读并同意代收协议");
        //finish();
    }
}