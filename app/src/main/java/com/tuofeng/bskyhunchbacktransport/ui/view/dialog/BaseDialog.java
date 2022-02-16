package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.tuofeng.bskyhunchbacktransport.R;

public abstract class BaseDialog extends Dialog {

    protected Context mContext;

    //pro浏览器 DialogSimpleUtils
    public BaseDialog(Context context) {
        super(context, R.style.MyDialogStyle);
        //super(context);
        mContext = context;
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //初始化布局控件
        initView();
        initWindow();
    }

    public void initWindow() {
        Window window = getWindow();
        //window.getDecorView().setPadding(0, 0, 0, 0);
        //设置背景透明，不然会出现白色直角问题
        //window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams params = getWindow().getAttributes();

        params.gravity = Gravity.TOP;
        /*params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;*/

        window.setAttributes(params);
        window.setGravity(Gravity.TOP);
        /*setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        //设置背景透明，不然会出现白色直角问题
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams params = getWindow().getAttributes();

        params.gravity = Gravity.TOP;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;

        window.setAttributes(params);
        window.setGravity(Gravity.TOP);*/
    }

    protected abstract void initView();

    protected abstract int getLayoutId();

    @Override
    public void show() {
        try {
            if (!isShowing() && mContext != null && !((Activity) mContext).isFinishing()) {
                super.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
