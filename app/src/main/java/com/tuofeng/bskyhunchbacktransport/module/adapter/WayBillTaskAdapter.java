package com.tuofeng.bskyhunchbacktransport.module.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMessageCenterAdapterBinding;
import com.tuofeng.bskyhunchbacktransport.databinding.WaybilltaskListLayoutBinding;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedLeftImgButton;

import java.util.List;

public class WayBillTaskAdapter extends RecyclerView.Adapter<WayBillTaskAdapter.ViewHolder> {

    private List<String> mList;
    private Context mContext;
    private RecycleBannerAdapter.onChildListener onChildListener;
    private MyOnClickListener mClickListener;

    public WayBillTaskAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(mContext);
        WaybilltaskListLayoutBinding mBinding = DataBindingUtil.inflate(inflate, R.layout.waybilltask_list_layout, parent, false);
        return new ViewHolder(mBinding.getRoot(), mBinding);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lLyaoutLeft.setOnClickListener(v -> mClickListener.onItemClick(1,position));
        holder.lLyaoutRight.setOnClickListener(v -> mClickListener.onItemClick(2,position));
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout lLyaoutLeft,lLyaoutRight;

        ViewHolder(View view, WaybilltaskListLayoutBinding mBinding) {
            super(view);
            lLyaoutLeft = mBinding.lLyaoutLeft;
            lLyaoutRight = mBinding.lLyaoutRight;
        }
    }

    public void setMyOnClickListener(MyOnClickListener clickListener) {
        mClickListener = clickListener;
    }

    public interface MyOnClickListener {
        void onItemClick(int type,int position);
    }
}