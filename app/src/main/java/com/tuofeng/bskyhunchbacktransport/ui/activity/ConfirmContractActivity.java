package com.tuofeng.bskyhunchbacktransport.ui.activity;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityConfirmContractBinding;
import com.tuofeng.bskyhunchbacktransport.in.IConfirmContractView;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.ConfirmContractViewModel;

public class ConfirmContractActivity extends BaseActivity<ActivityConfirmContractBinding,ConfirmContractViewModel> implements IConfirmContractView {


    @Override
    protected ConfirmContractViewModel getViewModel() {
        return new ConfirmContractViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_confirm_contract;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mToolbarTitle.setText("承运合同");
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PreviousAction() {
        ToastUtil.shortToast("完成");
    }
}