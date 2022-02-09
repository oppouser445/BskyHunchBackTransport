package com.tuofeng.bskyhunchbacktransport.module.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class BannerPagerAdapter extends PagerAdapter {
    private List<ImageView> mViewList;
    private final String TAG = "BannerPagerAdapter";

    //也可以重写构造器，传入Context，然后在PagerAdapter
    //中初始话Layout布局，感觉这种通用一些
    public BannerPagerAdapter(List<ImageView> mViewList, ViewPager viewPager) {
        this.mViewList = mViewList;
    }

    @Override
    public int getCount() {
        //返回有效的View的个数
        return /*mViewList.size()*/Integer.MAX_VALUE;
    }

    //判断是否page view与 instantiateItem(ViewGroup, int)返回的object的key 是否相同，以提供给其他的函数使用
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //instantiateItem该方法的功能是创建指定位置的页面视图。finishUpdate(ViewGroup)返回前，页面应该保证被构造好
    //返回值：返回一个对应该页面的object，这个不一定必须是View，但是应该是对应页面的一些其他容器
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //若position超过mDataList.size()，会发生越界异常，所以这里每次超过size又从0开始计算位置
        position = position % mViewList.size();
        ImageView imageView = mViewList.get(position);
        container.addView(imageView);
        return imageView;
    }

    //该方法的功能是移除一个给定位置的页面。
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        position = position % mViewList.size();
        //container.removeView((View) object);
        container.removeView(mViewList.get(position));
        //super.destroyItem(container, position, object);
    }

    // 无论是创建View添加到容器中 还是 销毁View 都是在此方法结束之后执行的
    /*@Override
    public void finishUpdate(@NonNull ViewGroup container) {
        super.finishUpdate(container);
        int position = mViewPager.getCurrentItem();
        if (position == 0) {
            position = mViewList.size() - 2;
            mViewPager.setCurrentItem(position, false);
        } else if (position == mViewList.size() - 1) {
            position = 1;
            mViewPager.setCurrentItem(position, false);
        }
    }*/
}