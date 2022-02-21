package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.content.Context;

import androidx.annotation.NonNull;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;

public class CheckBankCardDialog extends BaseDialog {

    private SharedButton mBtnOk;

    public CheckBankCardDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.add_check_bank_card_dialog_layout;
    }

    @Override
    protected void initView() {
        mBtnOk = findViewById(R.id.btn_ok);

        mBtnOk.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onClick();
            }
            dismiss();
        });
    }

    private MyClicklListener mListener;

    public void setMyClickListener(MyClicklListener listener) {
        this.mListener = listener;
    }

    public interface MyClicklListener {
        void onClick();
    }
}