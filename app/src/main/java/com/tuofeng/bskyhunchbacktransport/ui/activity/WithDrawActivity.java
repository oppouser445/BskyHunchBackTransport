package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.view.View;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.contract.WithDrawContract;
import com.tuofeng.bskyhunchbacktransport.databinding.ActivityWithDrawBinding;
import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.WithDrawDialog;
import com.tuofeng.bskyhunchbacktransport.viewmodel.activity.WithDrawVM;

public class WithDrawActivity extends BaseActivity<ActivityWithDrawBinding, WithDrawVM> implements WithDrawContract.IWithDrawView, View.OnClickListener {

    @Override
    protected WithDrawVM getViewModel() {
        return new WithDrawVM(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_with_draw;
    }

    @Override
    protected void initView() {
        initTitleBar();
        mDataBinding.setViewModel(mViewModel);
        mToolbarTitle.setText("提现");
        mTvRightClick.setText("提现记录");
        mTvRightClick.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_right_click:
                break;
        }
    }

    @Override
    public void withDrawOnclick() {
        WithDrawDialog drawDialog = new WithDrawDialog(this);
        drawDialog.show();
    }
}