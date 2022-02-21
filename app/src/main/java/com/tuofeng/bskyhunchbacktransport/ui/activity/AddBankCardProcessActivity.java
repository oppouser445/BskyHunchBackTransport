package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityAddBankCardProcessBinding;
import com.tuofeng.bskyhunchbacktransport.in.IAddBankCardView;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.AddBankCardDialog;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.AddBankCardViewModel;

public class AddBankCardProcessActivity extends BaseActivity<ActivityAddBankCardProcessBinding, AddBankCardViewModel> implements IAddBankCardView {


    @Override
    protected AddBankCardViewModel getViewModel() {
        return new AddBankCardViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_bank_card_process;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mDataBinding.setViewModel(mViewModel);
        mToolbarTitle.setText("添加银行卡");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void nextActivity() {
        AddBankCardDialog addBankCardDialog = new AddBankCardDialog(this);
        addBankCardDialog.setMyClickListener(new AddBankCardDialog.MyClicklListener() {
            @Override
            public void onClick() {
                Intent intent = new Intent(AddBankCardProcessActivity.this, AddBankCardProcessActivity2.class);
                startActivity(intent);
            }
        });
        addBankCardDialog.show();
    }
}