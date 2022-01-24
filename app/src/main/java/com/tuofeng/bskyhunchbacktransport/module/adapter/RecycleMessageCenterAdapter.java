package com.tuofeng.bskyhunchbacktransport.module.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.BR;
import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.databinding.FragmentMessageCenterAdapterBinding;

import java.util.List;

public class RecycleMessageCenterAdapter extends RecyclerView.Adapter<RecycleMessageCenterAdapter.ViewHolder> {
    private List<String> mList;
    private Context mContext;
    private onChildListener onChildListener;

    public void setOnChildListener(RecycleMessageCenterAdapter.onChildListener onChildListener) {
        this.onChildListener = onChildListener;
    }

    public RecycleMessageCenterAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(mContext);
        FragmentMessageCenterAdapterBinding mBinding = DataBindingUtil.inflate(inflate, R.layout.fragment_message_center_adapter, parent, false);
        return new ViewHolder(mBinding.getRoot(),mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FragmentMessageCenterAdapterBinding binding = holder.getBinding();
        LinearLayout lLyaoutMessageCenterAdapterHomeLayout = binding.lLyaoutMessageCenterAdapterHomeLayout;
        lLyaoutMessageCenterAdapterHomeLayout.setOnClickListener(v -> onChildListener.onChildListener(v, position));
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        FragmentMessageCenterAdapterBinding mBinding;

        ViewHolder(View view, FragmentMessageCenterAdapterBinding binding) {
            super(view);
            mBinding = binding;
        }

        public FragmentMessageCenterAdapterBinding getBinding() {
            return mBinding;
        }
    }

    public interface onChildListener {
        void onChildListener(View view, int position);
    }
}