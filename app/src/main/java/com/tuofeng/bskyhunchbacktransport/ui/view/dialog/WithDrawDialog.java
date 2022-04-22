package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;

public class WithDrawDialog extends BaseDialog {

    private TextView mTvTitle, mTvContent, mTvLeft, mTvRight;

    public WithDrawDialog(Context context) {
        super(context);
    }

    public WithDrawDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected WithDrawDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initView() {
        mTvTitle = findViewById(R.id.tv_title);
        mTvContent = findViewById(R.id.tv_content);
        mTvLeft = findViewById(R.id.tv_left);
        mTvRight = findViewById(R.id.tv_right);

        mTvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mTvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_withdraw_layout;
    }

}
