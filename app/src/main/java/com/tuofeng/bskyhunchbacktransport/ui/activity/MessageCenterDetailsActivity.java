package com.tuofeng.bskyhunchbacktransport.ui.activity;

import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.ui.view.LoginActButton;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;
import com.tuofeng.bskyhunchbacktransport.viewmodel.BaseViewModel;

public class MessageCenterDetailsActivity extends BaseActivity {
    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.message_center_details;
    }

    @Override
    protected void initView() {
        StatusBarUtil.setTransparentStatusBar(getWindow(), 1);
        LoginActButton actButton = findViewById(R.id.bnt_message_details);
        actButton.setOnClickListener(v -> finish());

        TextView tvTitleBar = findViewById(R.id.toolbar_title);
        tvTitleBar.setText("消息详情");
    }

    @Override
    protected void initData() {

    }
}
