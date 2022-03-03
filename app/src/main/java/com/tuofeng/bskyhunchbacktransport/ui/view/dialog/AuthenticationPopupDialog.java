package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;

public class AuthenticationPopupDialog extends BaseDialog {

    private TextView mTvTitle, mTvContent, mTvLeft, mTvRight;

    public AuthenticationPopupDialog(Context context) {
        super(context);
    }

    public AuthenticationPopupDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected AuthenticationPopupDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initView() {
        mTvTitle = findViewById(R.id.tv_title);
        mTvContent = findViewById(R.id.tv_content);
        mTvLeft = findViewById(R.id.tv_left);
        mTvRight = findViewById(R.id.tv_right);

        //mStyle
        mTvTitle.setText("尚未进行信息认证");
        mTvContent.setText("信息认证通过后，才能进行 合同签订。请前");
        mTvLeft.setText("稍后再说");
        mTvRight.setText("立刻认证");

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
        return R.layout.collection_invitations_layout;
    }

}
