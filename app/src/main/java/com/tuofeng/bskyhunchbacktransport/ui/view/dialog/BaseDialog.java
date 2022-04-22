package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;

public abstract class BaseDialog extends Dialog {

    protected Context mContext;
    protected Window mWindow;
    protected WindowManager.LayoutParams mParamsWindow;

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

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        StatusBarUtil.setLightStatusBar((Activity) mContext, true);
        //初始化布局控件
        initView();
        initWindow();


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

            WindowManager.LayoutParams lp = getWindow().getAttributes();
            //LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES是允许在刘海区域布局
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            getWindow().setAttributes(lp);
        } else {//4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public void initWindow() {
        mWindow = getWindow();
        mWindow.setGravity(Gravity.CENTER);

        mParamsWindow = getWindow().getAttributes();
        mParamsWindow.width = WindowManager.LayoutParams.MATCH_PARENT;
        mParamsWindow.height = WindowManager.LayoutParams.MATCH_PARENT;
        mParamsWindow.gravity = Gravity.CENTER;
        mWindow.setAttributes(mParamsWindow);

        //window.getDecorView().setPadding(0, 0, 0, 0);
        //设置背景透明，不然会出现白色直角问题
        //window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        /*setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();

        window.getDecorView().setPadding(0, 0, 0, 0);
        //设置背景透明，不然会出现白色直角问题
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setGravity(Gravity.TOP);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;

        window.setAttributes(params);*/
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
