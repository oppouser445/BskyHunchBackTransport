package com.tuofeng.bskyhunchbacktransport.ui.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.module.bean.ImageTitleBean;
import com.tuofeng.bskyhunchbacktransport.utils.LogUtils;
import com.tuofeng.bskyhunchbacktransport.utils.ViewMyUtils;

import java.util.ArrayList;
import java.util.List;

public class ImageSlideshow extends FrameLayout {

    private static final String TAG = "ImageSlideshow";
    private Context mContext;
    private View contentView;
    private ViewPager mViewPager;
    private LinearLayout llDot;
    private int count;
    private List<View> viewList;
    private boolean isAutoPlay;
    private Handler handler;
    private int currentItem;
    /*private Animator animatorToLarge;
    private Animator animatorToSmall;*/
    private SparseBooleanArray isLarge;
    private List<ImageTitleBean> mDataList;
    private int dotSize = 12;
    private int dotSpace = 12;
    private int delay = 3000;
    private ImageTitlePagerAdapter mAdapter;
    private int mLastSubscript;

    public ImageSlideshow(Context context) {
        this(context, null);
    }

    public ImageSlideshow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageSlideshow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
        initAnimator();
        initData();
    }

    private void initData() {
        mDataList = new ArrayList<>();
    }

    private void initAnimator() {
        /*animatorToLarge = AnimatorInflater.loadAnimator(mContext, R.animator.banner_scale_to_large);
        animatorToSmall = AnimatorInflater.loadAnimator(mContext, R.animator.banner_scale_to_small);*/
    }

    private void initView() {
        contentView = LayoutInflater.from(mContext).inflate(R.layout.is_main_layout, this, true);
        mViewPager = (ViewPager) findViewById(R.id.vp_image_title);
        llDot = (LinearLayout) findViewById(R.id.ll_dot);
    }

    // 设置小圆点的大小
    public void setDotSize(int dotSize) {
        this.dotSize = dotSize;
    }

    // 设置小圆点的间距
    public void setDotSpace(int dotSpace) {
        this.dotSpace = dotSpace;
    }

    // 设置图片轮播间隔时间
    public void setDelay(int delay) {
        this.delay = delay;
    }

    // 添加图片和标题
    public void addImageTitle(String imageUrl, String title, int imageId) {
        ImageTitleBean imageTitleBean = new ImageTitleBean();
        imageTitleBean.setImageUrl(imageUrl);
        imageTitleBean.setTitle(title);
        imageTitleBean.setImageId(imageId);
        mDataList.add(imageTitleBean);
    }

    // 添加图片和标题的JavaBean
    public void addImageTitleBean(ImageTitleBean imageTitleBean) {
        mDataList.add(imageTitleBean);
    }

    // 设置图片和标题的JavaBean数据列表
    public void setImageTitleBeanList(List<ImageTitleBean> imageTitleBeanList) {
        this.mDataList = imageTitleBeanList;
    }

    // 设置完后最终提交
    public void commit() {
        if (mDataList != null) {
            count = mDataList.size();
            // 设置ViewPager
            setViewPager(mDataList);
            // 设置指示器
            setIndicator();
            // 开始播放
            startPlay();
            LogUtils.e(TAG,"启动调用commit");
        } else {
            Log.e(TAG, "数据为空");
        }
    }

    /**
     * 设置指示器
     */
    private void setIndicator() {
        isLarge = new SparseBooleanArray();
        // 记得创建前先清空数据，否则会受遗留数据的影响。
        llDot.removeAllViews();
        for (int i = 0; i < count; i++) {
            isLarge.put(i, false);
        }
        ViewMyUtils.initDotsLayoutStyle(mContext, llDot);
        /*animatorToLarge.setTarget(llDot.getChildAt(0));
        animatorToLarge.start();*/
        isLarge.put(0, true);
    }

    /**
     * 开始自动播放图片
     */
    public void startPlay() {
        // 如果少于2张就不用自动播放了
        if (count < 2) {
            isAutoPlay = false;
        } else {
            isAutoPlay = true;
            handler = new Handler();
            handler.removeCallbacks(task);
            handler.postDelayed(task, delay);
            LogUtils.e(TAG,"启动调用startPlay");
        }
    }

    public void stopPlay() {
        handler.removeCallbacks(task);
    }

    private Runnable task = new Runnable() {
        @Override
        public void run() {
            if (isAutoPlay) {
                // 位置循环
                //currentItem = currentItem % (count + 1) + 1;
                currentItem = mViewPager.getCurrentItem() + 1;
                // 正常每隔3秒播放一张图片
                mViewPager.setCurrentItem(currentItem);
                handler.postDelayed(task, delay);
                LogUtils.e(TAG,"切换下一章");
            } else {
                // 如果处于拖拽状态停止自动播放，会每隔5秒检查一次是否可以正常自动播放。
                handler.postDelayed(task, 5000);
            }
        }
    };

    // 创建监听器接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    // 声明监听器
    private OnItemClickListener onItemClickListener;

    // 提供设置监听器的公共方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    class ImageTitlePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = viewList.get(position);
            // 设置Item的点击监听器
            view.setOnClickListener(v -> {
                // 注意：位置是position-1
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, position - 1);
                }
            });
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }

    /**
     * 设置ViewPager
     *
     * @param imageTitleBeanList
     */
    private void setViewPager(List<ImageTitleBean> imageTitleBeanList) {
        // 设置View列表
        setViewList(imageTitleBeanList);
        mAdapter = new ImageTitlePagerAdapter();
        mViewPager.setAdapter(mAdapter);
        // 从第1张图片开始（位置刚好也是1，注意：0位置现在是最后一张图片）
        currentItem = 1;
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                // 遍历一遍子View，设置相应的背景。

                /*for (int i = 0; i < llDot.getChildCount(); i++) {
                    if (i == position - 1) {// 被选中
                        if (!isLarge.get(i)) {
                                *//*animatorToLarge.setTarget(llDot.getChildAt(i));
                                animatorToLarge.start();*//*
                            isLarge.put(i, true);
                        }
                    } else {// 未被选中
                        if (isLarge.get(i)) {
                                *//*animatorToSmall.setTarget(llDot.getChildAt(i));
                                animatorToSmall.start();*//*
                            isLarge.put(i, false);
                        }
                    }
                }*/
                position = position == viewList.size() - 1 ? 1 : position;// 滑动到最后一页时设置第一个点选中
                position = position == 0 ? viewList.size() - 2 : position;// 滑动到第一页时设置最后一个点选中
                ViewMyUtils.setDotsLayoutStyle(mContext, position, llDot);
                //mLastSubscript = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int position = mViewPager.getCurrentItem();
                switch (state) {
                    // 当用户滑动的时候松手
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (position == 0) {
                            mViewPager.setCurrentItem(mAdapter.getCount() - 2, false);
                        } else if (position == mAdapter.getCount() - 1) {
                            mViewPager.setCurrentItem(1, false);
                        }
                        currentItem = position;
                        isAutoPlay = true;
                        break;
                    // 拖动中 当用户按下ViewPager视图并且需要滑动第一下时;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        isAutoPlay = false;
                        break;
                    // 设置中 当用户滑动的放手让其惯性滑动的时候，比如滑了放手触发。如果用户滑了左手边一点然后不松手滑回原点 将不会触发
                    case ViewPager.SCROLL_STATE_SETTLING:
                        isAutoPlay = true;
                        break;
                }
            }
        });
    }

    /**
     * 根据出入的数据设置View列表
     */
    private void setViewList(List<ImageTitleBean> imageTitleBeanList) {
        viewList = new ArrayList<>();
        for (int i = 0; i < count + 2; i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.is_image_title_layout, null);
            ImageView ivImage = (ImageView) view.findViewById(R.id.iv_image);
            TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
            if (i == 0) {// 将最前面一页设置成本来最后的那页
                Glide.with(mContext).
                        load(imageTitleBeanList.get(count - 1).getImageId()).into(ivImage);
                tvTitle.setText(imageTitleBeanList.get(count - 1).getTitle());
            } else if (i == count + 1) {// 将最后面一页设置成本来最前的那页
                Glide.with(mContext).
                        load(imageTitleBeanList.get(0).getImageId()).into(ivImage);
                tvTitle.setText(imageTitleBeanList.get(0).getTitle());
            } else {
                Glide.with(mContext).
                        load(imageTitleBeanList.get(i - 1).getImageId()).into(ivImage);
                tvTitle.setText(imageTitleBeanList.get(i - 1).getTitle());
            }
            // 将设置好的View添加到View列表中
            viewList.add(view);
        }
    }

    /**
     * 释放资源
     */
    public void releaseResource() {
        handler.removeCallbacksAndMessages(null);
        mContext = null;
    }
}