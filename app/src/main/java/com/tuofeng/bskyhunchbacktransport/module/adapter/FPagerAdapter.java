package com.tuofeng.bskyhunchbacktransport.module.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tuofeng.bskyhunchbacktransport.ui.fragment.BaseFragment;

import java.util.List;

public class FPagerAdapter extends FragmentPagerAdapter {

    private List<String> mTitles;
    private List<BaseFragment> mFragments;

    public FPagerAdapter(@NonNull FragmentManager fm, List<BaseFragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
