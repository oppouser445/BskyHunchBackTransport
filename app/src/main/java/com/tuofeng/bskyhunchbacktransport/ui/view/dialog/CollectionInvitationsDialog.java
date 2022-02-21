package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;

public class CollectionInvitationsDialog extends BaseDialog {

    private int mStyle;

    private TextView mTvTitle, mTvContent, mTvLeft, mTvRight;

    public CollectionInvitationsDialog(Context context) {
        super(context);
    }

    public CollectionInvitationsDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CollectionInvitationsDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initView() {
        mTvTitle = findViewById(R.id.tv_title);
        mTvContent = findViewById(R.id.tv_content);
        mTvLeft = findViewById(R.id.tv_left);
        mTvRight = findViewById(R.id.tv_right);

        //mStyle
        mTvTitle.setText(mStyle == 1 ? "确认拒绝代收运费？" : "确定解除代收并退出车队？");
        mTvContent.setText(mStyle == 1 ? "拒绝代收运费同此带来的问题，\n" +
                "将与平台无关？" : "解除代收将退出车队，解除之前 的运单收益");
        mTvLeft.setText(mStyle == 1 ? "我再想想" : "仍旧解除");
        mTvRight.setText(mStyle == 1 ? "仍旧解除" : "确认");

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

    public void setmStyle(int mStyle) {
        this.mStyle = mStyle;
    }

}
