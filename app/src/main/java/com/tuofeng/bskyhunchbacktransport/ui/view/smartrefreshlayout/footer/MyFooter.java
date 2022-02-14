package com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.footer;

import static android.view.View.MeasureSpec.EXACTLY;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.drawable.ProgressDrawable;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshFooter;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshKernel;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.api.RefreshLayout;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.constant.RefreshState;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.constant.SpinnerStyle;
import com.tuofeng.bskyhunchbacktransport.ui.view.smartrefreshlayout.layout.util.SmartUtil;


public class MyFooter extends RelativeLayout implements RefreshFooter {

    private TextView mTitleText;//标题文本
    private ImageView mProgressView;//刷新动画视图
    private ProgressDrawable mProgressDrawable;//刷新动画
    private Context mContext;

    protected int mMinHeightOfContent = 0;
    protected int mPaddingTop = 20;
    protected int mPaddingBottom = 20;
    private View arrowView;
    private View progressView;
    protected ImageView mArrowView;

    public MyFooter(Context context) {
        this(context, null);
        mContext = context;
        this.initView(context);
    }

    public MyFooter(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        mContext = context;
    }

    public MyFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    private void initView(Context context) {
        setGravity(Gravity.CENTER);
        //setBackgroundColor(mContext.getResources().getColor(R.color.main_default_bg_color));

        final View thisView = View.inflate(mContext, R.layout.srl_classics_footer_test, this);
        arrowView = mArrowView = thisView.findViewById(R.id.srl_classics_arrow);
        progressView = mProgressView = thisView.findViewById(R.id.srl_classics_progress);

        mProgressDrawable = new ProgressDrawable();
        mProgressDrawable.setColor(0xff666666);
        mProgressView.setImageDrawable(mProgressDrawable);

        mTitleText = thisView.findViewById(R.id.srl_classics_title);


        /*mHeaderText = new TextView(context);
        mProgressDrawable = new ProgressDrawable();
        mProgressView = new ImageView(context);
        mProgressView.setImageDrawable(mProgressDrawable);
        addView(mProgressView, SmartUtil.dp2px(20), SmartUtil.dp2px(20));
        addView(new View(context), SmartUtil.dp2px(20), SmartUtil.dp2px(20));
        addView(mHeaderText, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        setMinimumHeight(SmartUtil.dp2px(60));

        setBackgroundResource(R.color.download_tv_color);*/
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final View thisView = this;
        if (mMinHeightOfContent == 0) {
            mPaddingTop = thisView.getPaddingTop();
            mPaddingBottom = thisView.getPaddingBottom();
            if (mPaddingTop == 0 || mPaddingBottom == 0) {
                int paddingLeft = thisView.getPaddingLeft();
                int paddingRight = thisView.getPaddingRight();
                mPaddingTop = mPaddingTop == 0 ? SmartUtil.dp2px(20) : mPaddingTop;
                mPaddingBottom = mPaddingBottom == 0 ? SmartUtil.dp2px(20) : mPaddingBottom;
                thisView.setPadding(paddingLeft, mPaddingTop, paddingRight, mPaddingBottom);
            }
            final ViewGroup thisGroup = this;
            thisGroup.setClipToPadding(false);
        }
        if (MeasureSpec.getMode(heightMeasureSpec) == EXACTLY) {
            final int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
            if (parentHeight < mMinHeightOfContent) {
                final int padding = (parentHeight - mMinHeightOfContent) / 2;
                thisView.setPadding(thisView.getPaddingLeft(), padding, thisView.getPaddingRight(), padding);
            } else {
                thisView.setPadding(thisView.getPaddingLeft(), 0, thisView.getPaddingRight(), 0);
            }
        } else {
            thisView.setPadding(thisView.getPaddingLeft(), mPaddingTop, thisView.getPaddingRight(), mPaddingBottom);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mMinHeightOfContent == 0) {
            final ViewGroup thisGroup = this;
            for (int i = 0; i < thisGroup.getChildCount(); i++) {
                final int height = thisGroup.getChildAt(i).getMeasuredHeight();
                if (mMinHeightOfContent < height) {
                    mMinHeightOfContent = height;
                }
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final View arrowView = mArrowView;
        final View progressView = mProgressView;
        arrowView.animate().cancel();
        progressView.animate().cancel();
        final Drawable drawable = mProgressView.getDrawable();
        if (drawable instanceof Animatable) {
            if (((Animatable) drawable).isRunning()) {
                ((Animatable) drawable).stop();
            }
        }
    }

    @NonNull
    public View getView() {
        return this;//真实的视图就是自己，不能返回null
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;//指定为平移，不能null
    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int headHeight, int maxDragHeight) {
        mProgressDrawable.start();//开始动画
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        mProgressDrawable.stop();//停止动画
        /*
        if (success){
            mHeaderText.setText("刷新完成");
        } else {
            mHeaderText.setText("刷新失败");
        }*/

        mTitleText.setText(success ? "刷新完成" : "刷新失败");

        return 500;//延迟500毫秒之后再弹回
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        /*switch (newState) {
            case None:
            case PullDownToRefresh:
                mTitleText.setText("下拉开始刷新");
                mArrowView.setVisibility(VISIBLE);//显示下拉箭头
                mProgressView.setVisibility(GONE);//隐藏动画
                mArrowView.animate().rotation(0);//还原箭头方向
                break;
            case Refreshing:
                mTitleText.setText("正在刷新");
                mProgressView.setVisibility(VISIBLE);//显示加载动画
                mArrowView.setVisibility(GONE);//隐藏箭头
                break;
            case ReleaseToRefresh:
                mTitleText.setText("释放立即刷新");
                mArrowView.animate().rotation(180);//显示箭头改为朝上
                break;
        }*/

        switch (newState) {
            case None:
                arrowView.setVisibility(VISIBLE);
            case PullUpToLoad://@上拉加载
                mTitleText.setText("上拉加载");
                arrowView.animate().rotation(180);
                break;
            case Loading:
            case LoadReleased://@正在加载…
                arrowView.setVisibility(GONE);
                mTitleText.setText("正在加载…");
                break;
            case ReleaseToLoad://@释放加载
                mTitleText.setText("释放加载");
                arrowView.animate().rotation(0);
                break;
            case Refreshing:
                mTitleText.setText("无类型");
                arrowView.setVisibility(GONE);
                break;
        }
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int maxDragHeight) {
    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void setPrimaryColors(@ColorInt int... colors) {
    }

    @Override
    public boolean setNoMoreData(boolean noMoreData) {
        return false;
    }
}
