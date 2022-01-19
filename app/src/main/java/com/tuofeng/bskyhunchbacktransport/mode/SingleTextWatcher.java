package com.tuofeng.bskyhunchbacktransport.mode;


import android.text.Editable;
import android.text.TextWatcher;

public class SingleTextWatcher implements TextWatcher {
    private CallBack callBack;

    public interface CallBack {
        void afterTextChanged(String s);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (callBack != null) {
            callBack.afterTextChanged(s.toString());
        }
    }
}
