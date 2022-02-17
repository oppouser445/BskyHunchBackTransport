package com.tuofeng.bskyhunchbacktransport.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;

import com.tuofeng.bskyhunchbacktransport.R;

public class SharedButton extends androidx.appcompat.widget.AppCompatButton {

    boolean mCancelled;
    private Rect mRect;
    private boolean mIsEnabled;
    private int mViewType;

    public SharedButton(Context context) {
        super(context);
        initView();
    }

    public SharedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        initAttrs(context, attrs);
    }

    public SharedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        initAttrs(context, attrs);
    }

    @SuppressLint("Recycle")
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.loginact_attrs);
        int mBgType = array.getInt(R.styleable.loginact_attrs_bgType, 0);
        mViewType = mBgType;
        setMyBackground();
    }

    private void initView() {
        mRect = new Rect();
        setGravity(Gravity.CENTER);
    }

    public void scaleTo(float scale) {
        setScaleX(scale);
        setScaleY(scale);
    }

    public void setMyBackground() {
        int bg = R.drawable.select_btn_resend;
        int tvColor = R.color.white;
        if (mViewType == 1) {
            bg = R.drawable.select_btn_bg2;
            tvColor = R.color.color_btn_bg_text_color;
        } else if (mViewType == 2) {//登录页 按钮逻辑
            bg = R.drawable.shape_btn_bg_orange;
        } else if (mViewType == 3) {//默认可点击状态
            bg = R.drawable.shape_btn_bg_orange;
        } else if (mViewType == 4) {
            bg = R.drawable.shape_btn_bg_grey;
            tvColor = R.color.main_orange_color;
        }
        setTextColor(getResources().getColor(tvColor));
        setBackgroundResource(bg);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mViewType == 2 && !mIsEnabled) {//登录页 按钮逻辑
            return super.onTouchEvent(event);
        }

        float MAX_CLICK_ZOOM_FACTOR = 0.9f;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                scaleTo(MAX_CLICK_ZOOM_FACTOR);
                break;
            case MotionEvent.ACTION_MOVE:
                if (mRect.isEmpty()) {
                    getDrawingRect(mRect);
                }
                if (!mRect.contains((int) event.getX(), (int) event.getY())) {
                    scaleTo(1);
                    mCancelled = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                initBtnView();
                break;
            case MotionEvent.ACTION_CANCEL: {
                initBtnView();
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    //获取View的绘制范围，即左、上、右、下边界相对于此View的左顶点的距离（偏移量），即0、0、View的宽、View的高
    //是否包含在Btn范围内
    //当手指从当前view移出后 调用此方法

    private void initBtnView() {
        if (!mCancelled) {
            scaleTo(1);
        } else {
            mCancelled = false;
        }
    }

    public void setMyEnabled(boolean b) {
        mIsEnabled = b;
    }
}