package com.tuofeng.bskyhunchbacktransport.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.tuofeng.bskyhunchbacktransport.R;

/**
 * description: ${带有倒计时功能的TextVeiw}
 */
public class DownTimerText extends AppCompatButton {
    int textNormalColor;
    String reGetVoiceCode = "重新获取";
    //倒计时
    private CountDownTimer countDownTimer;
    //这个倒计时监听不和ui相关联
    private CountDownTimer staticDownTimer;
    //总时间
    private int totalTimeMills;

    private int mfrequency;//倒计时数值

    public DownTimerText(Context context) {
        this(context, null);
        init();
    }

    public DownTimerText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init();
        initAttrs(context,attrs);
    }

    public DownTimerText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initAttrs(context,attrs);
    }

    /**
     * 初始化
     */
    private void init() {
        mfrequency = 5;
        totalTimeMills = mfrequency * 1000;
        initCountDownTimerUi();
        //initCountDownTimer();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.loginact_countdown_attrs);
        textNormalColor = array.getInt(R.styleable.loginact_countdown_attrs_textCountdownColor, 0);
    }

    /**
     * 初始化 带有倒计时UI变化的 countDownTimer
     */
    private void initCountDownTimerUi() {
        countDownTimer = new CountDownTimer(totalTimeMills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                setEnabled(false);
                setTextColor(textNormalColor);
                mfrequency--;

                long mills = millisUntilFinished / 1000;
                if (mfrequency > 0) {
                    if (mills < 10) {
                        setText("0" + mfrequency);
                    } else {
                        setText(String.valueOf(mfrequency));
                    }
                } else {
                    setEnabled(true);
                    setTextColor(textNormalColor);
                    setText(reGetVoiceCode);
                    mfrequency = 5;
                    onCountDownTimer.onFinish();
                }
                onCountDownTimer.onTick(mfrequency);
                /*long mills = millisUntilFinished / 1000;
                if (mills < 10) {
                    setText("0" + mills);
                } else {
                    setText(String.valueOf(mills));
                }*/
            }

            @Override
            public void onFinish() {
                setEnabled(true);
                setTextColor(textNormalColor);
                setText(reGetVoiceCode);
                onCountDownTimer.onFinish();
            }
        };
    }

    /**
     * 初始化 CountDownTimer
     */
    private void initCountDownTimer() {
        staticDownTimer = new CountDownTimer(totalTimeMills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (onCountDownTimer != null) {
                    onCountDownTimer.onTick(millisUntilFinished);
                }
            }

            @Override
            public void onFinish() {
                if (onCountDownTimer != null) {
                    onCountDownTimer.onFinish();
                }
            }
        };
    }

    /**
     * 设置倒计时 有Ui倒计时变化的
     *
     * @param
     */
    public void startCountDownWithUi() {
        if (countDownTimer != null) {
            countDownTimer.start();
        } else {
            initCountDownTimerUi();
            countDownTimer.start();
        }
    }

    /**
     * 启动 没有UI变化
     */
    public void startCountDownTimer() {
        if (staticDownTimer != null) {
            staticDownTimer.start();
        } else {
            initCountDownTimer();
            staticDownTimer.start();
        }
    }

    /**
     * 解绑
     */
    public void unRegisterCountDownListener() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        if (onCountDownTimer != null) {
            onCountDownTimer = null;
        }
        if (staticDownTimer != null) {
            staticDownTimer.cancel();
            staticDownTimer = null;
        }
    }

    public OnCountDownTimer onCountDownTimer;

    /**
     * 倒计时接口
     */
    public interface OnCountDownTimer {
        //剩余多少秒
        void onTick(long millisUntilFinished);

        //计时结束
        void onFinish();
    }

    /**
     * 设置倒计时监听
     */
    public void setCountDownTimer(OnCountDownTimer countDownTimer) {
        this.onCountDownTimer = countDownTimer;
    }
}
