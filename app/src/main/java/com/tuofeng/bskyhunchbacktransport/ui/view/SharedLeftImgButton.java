package com.tuofeng.bskyhunchbacktransport.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.utils.CommonUtil;

import org.w3c.dom.Text;

public class SharedLeftImgButton extends LinearLayout {

    boolean mCancelled;
    private Rect mRect;
    private boolean mIsEnabled;
    private int mViewType;
    private Context mContext;

    public SharedLeftImgButton(Context context) {
        super(context);
        initView();
    }

    public SharedLeftImgButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        initAttrs(context, attrs);
    }

    public SharedLeftImgButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        initAttrs(context, attrs);
    }

    @SuppressLint("Recycle")
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.loginact_attrs);
        int mBgType = array.getInt(R.styleable.loginact_attrs_bgType, 0);
        mViewType = mBgType;
        mContext = context;
        setMyBackground();
    }

    private void initView() {
        mRect = new Rect();
        //setTextSize(CommonUtil.dp2px(14));

        LinearLayout.LayoutParams imgParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(R.mipmap.telephone);
        addView(imageView,imgParams);

        LinearLayout.LayoutParams tvParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(mContext);
        textView.setText("装货电话");
        textView.setTextColor(mContext.getResources().getColor(R.color.white));
        textView.setTextSize(14);
        textView.setPadding(0, 0, CommonUtil.dp2px(5), 0);
        addView(textView,tvParams);

        setGravity(Gravity.CENTER);
    }

    public void scaleTo(float scale) {
        setScaleX(scale);
        setScaleY(scale);
    }

    public void setMyBackground() {
        int bg = R.drawable.select_btn_resend;//默认橘色
        int tvColor = R.color.white;
        if (mViewType == 1) {//装货发车
            bg = R.drawable.shape_shared_left_img_btn_style1;
            tvColor = R.color.main_orange_color;
        } else if (mViewType == 2) {//前往发货
            bg = R.drawable.shape_shared_left_img_btn_style2;
            tvColor = R.color.shared_left_img_btn_tv_color;
        }
        //setTextColor(getResources().getColor(tvColor));
        setBackgroundResource(bg);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
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