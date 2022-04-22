package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.utils.StatusBarUtil;

/**
 * Created by Tracy Wang on 18-11-21
 */
public class RoundCornerDialog extends BaseDialog implements View.OnClickListener {
    private TextView tvTitle;
    private View tvTitleDivider;
    private TextView tvDes;
    private TextView tvCancel;
    private TextView tvConfirm;
    private View splitLine;
    //private Context context;
    private String title;
    private String message;
    private String confirmText;
    private String predictText;
    private String cancelText;
    private int titleColorBg;
    private int confirmColorBg;
    private int cancelColorBg;
    private int confirmTextColor = 0;
    private boolean hideCancelBtn = false;
    private Context mContext;
    /**
     * 一个参数的构造方法
     *
     * @param context 上下文对象
     */
    public RoundCornerDialog(@NonNull Context context) {
        super(context);
        this.mContext=context;
    }

    /**
     * 初始化布局文件及设置参数
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    protected void initView() {
        //对话框标题
        tvTitle = findViewById(R.id.tv_title);
        tvTitleDivider = findViewById(R.id.tv_title_divider);
        //对话框描述信息
        tvDes = findViewById(R.id.tv_des);
        //确定按钮和取消
        tvConfirm = findViewById(R.id.tv_confirm);
        tvCancel = findViewById(R.id.tv_cancel);
        splitLine = findViewById(R.id.bank_round_dialog_divider_line);

        //设置标题、描述及确定按钮的文本内容
        if (title != null && title.trim().length() > 0) {
            tvTitle.setText(title);
        } else {
            tvTitle.setVisibility(View.GONE);
            tvTitleDivider.setVisibility(View.GONE);
        }
        if (message != null && message.trim().length() > 0) {
            tvDes.setText(message);
        }
        tvConfirm.setText(confirmText);
        tvCancel.setText(cancelText);

        if (confirmTextColor != 0) {
            tvConfirm.setTextColor(confirmTextColor);
        }

        if(hideCancelBtn){
            tvCancel.setVisibility(View.GONE);
            splitLine.setVisibility(View.GONE);
        }else{
            tvCancel.setVisibility(View.VISIBLE);
            splitLine.setVisibility(View.VISIBLE);
        }
        initEvent();
    }

    @Override
    public void initWindow() {
        super.initWindow();
        mWindow.setGravity(Gravity.CENTER);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.bank_round_corner_dialog_layout;
    }

    /**
     * 确定及取消点击事件
     */
    private void initEvent() {
        tvConfirm.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
    }


    /**
     * 设置标题栏文本
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 设置描述信息
     *
     * @param message 描述信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 设置确定按钮上的文本
     *
     * @param confirmText 文本
     */
    public void setConfirmText(String confirmText) {
        this.confirmText = confirmText;
    }
    //设置meassge2的文本
    public void setPredictText(String predictText) {
        this.predictText = predictText;
    }

    /**
     * 设置取消按钮上的文本
     *
     * @param cancelText 文本
     */
    public void setCancelText(String cancelText) {
        this.cancelText = cancelText;
    }

    /**
     * 设置标题栏的背景
     *
     * @param titleColorBg 背景色int
     */
    public void setTitleBg(int titleColorBg) {
        this.titleColorBg = titleColorBg;
    }

    /**
     * 确定按钮背景色
     *
     * @param confirmColorBg int背景色
     */
    public void setConfirmBg(int confirmColorBg) {
        this.confirmColorBg = confirmColorBg;
    }


    /**
     * 设置确认按钮字体颜色
     *
     * @param confirmTextColor
     */
    public void setConfirmTextColor(int confirmTextColor) {
        this.confirmTextColor = confirmTextColor;
    }

    /**
     * 取消按钮背景色
     *
     * @param cancelColorBg int背景色
     */
    public void setCancelBg(int cancelColorBg) {
        this.cancelColorBg = cancelColorBg;
    }

    private ConfirmListener confirmListener;
    private CancelListener cancelListener;

    /**
     * 设置确定按钮的监听
     *
     * @param confirmListener
     */
    public void setConfirmListener(ConfirmListener confirmListener) {
        this.confirmListener = confirmListener;
    }

    public void setCancelListener(CancelListener cancelListener) {
        this.cancelListener = cancelListener;
    }

    public void setHideCancelBtn(boolean hide) {
        hideCancelBtn = hide;
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.tv_confirm) {
            confirmListener.onConfirmClick();
            dismiss();
        } else if (i == R.id.tv_cancel) {
            cancelListener.onCancelClick();
            dismiss();
        }
    }

    /**
     * 确定按钮点击的监听接口
     */
    public interface ConfirmListener {
        void onConfirmClick();
    }

    public interface CancelListener {
        void onCancelClick();
    }


}
