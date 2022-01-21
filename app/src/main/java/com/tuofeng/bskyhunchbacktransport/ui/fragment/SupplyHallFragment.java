package com.tuofeng.bskyhunchbacktransport.ui.fragment;

import android.widget.RadioButton;
import android.widget.RadioGroup;

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

public class SupplyHallFragment extends BaseFragment<FragmentSupplyHallBinding, FragmentSupplyHallViewModel> implements ISupplyHallFragmentView {

    private RecyclerView rListFragmentSupplyHall;
    private FragmentActivity mActivity;
    private RecycleBannerAdapter mRecycleBannerAdapter;
    private List<String> mDataList;
    private RadioGroup mRbtnSupplyHallHome;
    private RadioButton rbtnSupplyHall;
    private RadioButton rbtnRecruitTeam;

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
    }

    @Override
    int getLayoutID() {
        return R.layout.fragment_supply_hall;
    }

    @Override
    FragmentSupplyHallViewModel getViewModel() {
        return new FragmentSupplyHallViewModel(this);
    }
}