package com.tuofeng.bskyhunchbacktransport.module.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMessageCenterAdapterBinding;

import java.util.List;

public class PersonnelManagementAdapter extends RecyclerView.Adapter<PersonnelManagementAdapter.ViewHolder> {

    private List<String> mList;
    private Context mContext;
    private RecycleBannerAdapter.onChildListener onChildListener;
    private MyOnClickListener mClickListener;

    public PersonnelManagementAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*LayoutInflater inflate = LayoutInflater.from(mContext);
        FragmentMessageCenterAdapterBinding mBinding = DataBindingUtil.inflate(inflate, R.layout.activity_vehicle_list_layout, parent, false);
        return new ViewHolder(mBinding.getRoot(), mBinding);
        return new ViewHolder(contentView);*/

        LayoutInflater inflate = LayoutInflater.from(mContext);
        /*WaybilltaskListLayoutBinding mBinding = DataBindingUtil.inflate(inflate, R.layout.activity_vehicle_list_layout, parent, false);
        return new ViewHolder(mBinding.getRoot(), mBinding)*/

        View contentView = inflate.inflate(R.layout.personnel_management_list_layout, parent, false);
        return new ViewHolder(contentView, null);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mLayoutItemHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mLayoutItemHome;

        ViewHolder(View view, FragmentMessageCenterAdapterBinding mBinding) {
            super(view);

            mLayoutItemHome = view.findViewById(R.id.lLayout_item_home);
        }
    }

    public void setMyOnClickListener(MyOnClickListener clickListener) {
        mClickListener = clickListener;
    }

    public interface MyOnClickListener {
        void onItemClick(int position);
    }
}