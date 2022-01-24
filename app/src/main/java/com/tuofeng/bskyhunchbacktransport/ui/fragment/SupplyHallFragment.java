package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentSupplyHallBinding;
import com.tuofeng.bskyhunchbacktransport.in.ISupplyHallFragmentView;
import com.tuofeng.bskyhunchbacktransport.module.adapter.RecycleBannerAdapter;
import com.tuofeng.bskyhunchbacktransport.viewmodel.fragment.FragmentSupplyHallViewModel;

import java.util.ArrayList;
import java.util.List;

public class SupplyHallFragment extends BaseFragment<FragmentSupplyHallBinding, FragmentSupplyHallViewModel> implements ISupplyHallFragmentView, View.OnClickListener {

    private RecyclerView rListFragmentSupplyHall;
    private FragmentActivity mActivity;
    private RecycleBannerAdapter mRecycleBannerAdapter;
    private List<String> mDataList;
    private RadioGroup mRbtnSupplyHallHome;
    private RadioButton rbtnSupplyHall;
    private RadioButton rbtnRecruitTeam;
    private LinearLayout mLlyaoutSort, mLlyaoutFilter, mLlyaoutTabHome, mLlyaoutNational, mLlyaoutNational2;

    @Override
    int getLayoutID() {
        return R.layout.fragment_supply_hall;
    }

    @Override
    FragmentSupplyHallViewModel getViewModel() {
        return new FragmentSupplyHallViewModel(this);
    }

    @Override
    void initView() {
        mActivity = getActivity();
        rListFragmentSupplyHall = mDataBinding.rListFragmentSupplyHall;
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        rListFragmentSupplyHall.setNestedScrollingEnabled(false);
        rListFragmentSupplyHall.setLayoutManager(mLayoutManager);

        mDataList = new ArrayList<>();
        mRecycleBannerAdapter = new RecycleBannerAdapter(mDataList, mActivity);
        rListFragmentSupplyHall.setAdapter(mRecycleBannerAdapter);

        //rbtn_supply_hall_home
        mRbtnSupplyHallHome = mDataBinding.rbtnSupplyHallHome;
        rbtnSupplyHall = mDataBinding.rbtnSupplyHall;
        rbtnRecruitTeam = mDataBinding.rbtnRecruitTeam;

        int color_orange = getResources().getColor(R.color.color_main_orange);
        int color_white = getResources().getColor(R.color.white);

        mRbtnSupplyHallHome.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rbtn_supply_hall:
                    rbtnSupplyHall.setTextColor(color_orange);
                    rbtnRecruitTeam.setTextColor(color_white);
                    break;
                case R.id.rbtn_recruit_team:
                    rbtnSupplyHall.setTextColor(color_white);
                    rbtnRecruitTeam.setTextColor(color_orange);
                    break;
            }
        });

        mLlyaoutTabHome = mDataBinding.llyaoutTabHome;

        mLlyaoutSort = mDataBinding.llyaoutSort;
        mLlyaoutSort.setOnClickListener(this);

        mLlyaoutFilter = mDataBinding.llyaoutFilter;
        mLlyaoutFilter.setOnClickListener(this);
        //llyaout_national
        mLlyaoutNational = mDataBinding.llyaoutNational;
        mLlyaoutNational.setOnClickListener(this);

        mLlyaoutNational2 = mDataBinding.llyaoutNational2;
        mLlyaoutNational2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llyaout_sort:
                setTabLayoutStyle(0);
                break;
            case R.id.llyaout_national:
                setTabLayoutStyle(1);
                break;
            case R.id.llyaout_national2:
                setTabLayoutStyle(2);
                break;
            case R.id.llyaout_filter:
                setTabLayoutStyle(3);
                break;
        }
    }

    private void setTabLayoutStyle(int index) {
        int childCount = mLlyaoutTabHome.getChildCount();
        for (int i = 0; i < childCount; i++) {
            LinearLayout linearLayout = (LinearLayout) mLlyaoutTabHome.getChildAt(i);
            TextView textView = (TextView) linearLayout.getChildAt(0);
            ImageView imageView = (ImageView) linearLayout.getChildAt(1);

            textView.setTextColor(getResources().getColor(index == i ? R.color.color_main_orange : R.color.fragment_supply_hall_table_tv_color));
            boolean b = i != childCount - 1;
            imageView.setImageResource(index == i ? b ? R.mipmap.triangle_orange_icon : R.mipmap.filter_icon : b ? R.mipmap.triangle_orange_icon_default : R.mipmap.filter_icon_default);
        }
    }
}