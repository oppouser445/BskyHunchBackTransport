package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.content.Intent;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityAddBankCardProcess2Binding;
import com.tuofeng.bskyhunchbacktransport.in.IAddBankCardView2;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.CheckBankCardDialog;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.AddBankCardViewModel2;

public class AddBankCardProcessActivity2 extends BaseActivity<ActivityAddBankCardProcess2Binding, AddBankCardViewModel2> implements IAddBankCardView2 {


    @Override
    protected AddBankCardViewModel2 getViewModel() {

        return new AddBankCardViewModel2(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_bank_card_process2;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void nextActivity() {
        CheckBankCardDialog bankCardDialog = new CheckBankCardDialog(this);
        bankCardDialog.show();
        bankCardDialog.setMyClickListener(new CheckBankCardDialog.MyClicklListener() {
            @Override
            public void onClick() {
                Intent intent = new Intent(AddBankCardProcessActivity2.this, BankCardActivity.class);
                startActivity(intent);
            }
        });
    }
}
