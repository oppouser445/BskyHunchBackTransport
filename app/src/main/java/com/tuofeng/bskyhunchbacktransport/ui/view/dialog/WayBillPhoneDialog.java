package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.tuofeng.bskyhunchbacktransport.R;

public class WayBillPhoneDialog extends BaseDialog {

    private LinearLayout mlLyaoutPhone;
    private TextView mTvCancel, mTvPhone;

    public WayBillPhoneDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.waybillphone_dialog_layout;
    }

    @Override
    protected void initView() {
        mlLyaoutPhone = findViewById(R.id.lLyaout_phone);
        mTvPhone = findViewById(R.id.tv_phone);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvCancel.setOnClickListener(v -> dismiss());
        mlLyaoutPhone.setOnClickListener(v -> {
            mListener.onClick(mTvPhone.getText().toString());
            dismiss();
        });
    }

    @Override
    public void initWindow() {
        super.initWindow();
        mWindow.setGravity(Gravity.BOTTOM);
    }

    private MyClicklListener mListener;

    public void setMyClickListener(MyClicklListener listener) {
        this.mListener = listener;
    }

    public interface MyClicklListener {
        void onClick(String data);
    }
}