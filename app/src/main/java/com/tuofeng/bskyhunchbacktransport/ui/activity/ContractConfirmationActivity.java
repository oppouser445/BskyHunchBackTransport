package com.tuofeng.bskyhunchbacktransport.ui.activity;


import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityContractConfirmationBinding;
import com.tuofeng.bskyhunchbacktransport.in.IContractConfirmationView;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.AuthenticationPopupDialog;
import com.tuofeng.bskyhunchbacktransport.utils.ToastUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.ContractConfirmationViewModel;

public class ContractConfirmationActivity extends BaseActivity<ActivityContractConfirmationBinding, ContractConfirmationViewModel> implements IContractConfirmationView {


    private Intent intent;
    private int mViewType;
    private SharedButton mBtnSigningContract;

    @Override
    protected ContractConfirmationViewModel getViewModel() {
        return new ContractConfirmationViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contract_confirmation;
    }

    @Override
    protected void initView() {
        initTitleBar();

        intent = getIntent();
        mViewType = intent.getIntExtra("viewType", 0);

        mToolbarTitle.setText(mViewType == 0 ? "合同确认" : "承运合同");
        mDataBinding.setViewModel(mViewModel);

        mBtnSigningContract = mDataBinding.btnSigningContract;
        mBtnSigningContract.setText(mViewType == 0 ? "签订合同(6/6)" : "签订合同");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void PreviousAction() {
        if (mViewType == 0) {
            Intent intent = new Intent(this, ConfirmContractActivity.class);
            startActivity(intent);
        } else {
            //ToastUtil.showCenterToast(this, "阅读并同意合同后，才能签订");
            AuthenticationPopupDialog popupDialog = new AuthenticationPopupDialog(this);
            popupDialog.show();
        }
    }
}