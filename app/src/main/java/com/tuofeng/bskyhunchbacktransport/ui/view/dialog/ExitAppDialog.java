package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;

public class ExitAppDialog extends BaseDialog implements View.OnClickListener {

    private TextView mTvLeft, mTvRight;

    public ExitAppDialog(Context context) {
        super(context);
    }

    public ExitAppDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ExitAppDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initView() {
        mTvLeft = findViewById(R.id.tv_left);
        mTvLeft.setOnClickListener(this);
        mTvRight = findViewById(R.id.tv_right);
        mTvRight.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.exit_app_dialog_layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_right:
                dismiss();
                break;
            case R.id.tv_left:
                dismiss();
                break;
        }
    }
}
