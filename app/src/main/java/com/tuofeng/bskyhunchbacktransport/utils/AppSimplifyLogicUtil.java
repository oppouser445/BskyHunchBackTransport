package com.tuofeng.bskyhunchbacktransport.utils;

import android.content.Context;
import android.text.TextUtils;

import com.tuofeng.bskyhunchbacktransport.ui.view.dialog.RoundCornerDialog;

public class AppSimplifyLogicUtil {
    //样式1 公共调用方法
    public static void showRoundCornerDialog(Context mContext, String title, String des, String btnTxt, String btnTxtConfirm, RoundCornerDialog.ConfirmListener confirmListener) {
        showRoundCornerDialog(mContext, title, des, btnTxt, btnTxtConfirm, confirmListener, () -> {

        });
    }

    public static void showRoundCornerDialog(Context mContext, String title, String des, String btnTxt, String btnTxtConfirm, RoundCornerDialog.ConfirmListener listener1, RoundCornerDialog.ConfirmListener listener2) {
        final RoundCornerDialog dialog = new RoundCornerDialog(mContext);
        dialog.setTitle(title);
        dialog.setMessage(des);
        dialog.setConfirmText(btnTxtConfirm);

        if (TextUtils.isEmpty(btnTxt)) {
            dialog.setHideCancelBtn(true);
        } else {
            dialog.setCancelText(btnTxt);
        }

        dialog.setCancelListener(() -> {
            dialog.dismiss();
            listener2.onConfirmClick();
        });

        dialog.setConfirmListener(listener1);
        dialog.show();
    }
}