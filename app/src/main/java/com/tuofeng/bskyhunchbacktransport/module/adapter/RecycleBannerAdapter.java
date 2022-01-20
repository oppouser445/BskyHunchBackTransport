package com.tuofeng.bskyhunchbacktransport.module.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

//import com.tuofeng.bskyhunchbacktransport.databinding.ActLoginBannerAdapterBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;

import java.util.List;

public class RecycleBannerAdapter extends RecyclerView.Adapter<RecycleBannerAdapter.ViewHolder> {
    private List<String> mList;
    private Context mContext;
    private onChildListener onChildListener;
    //private ActLoginBannerAdapterBinding mBinding;

    public void setOnChildListener(RecycleBannerAdapter.onChildListener onChildListener) {
        this.onChildListener = onChildListener;
    }

    public RecycleBannerAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(mContext);

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_test_item,parent,false)
        View contentView = inflate.inflate(R.layout.act_login_banner_adapter,parent, false);
        //mBinding = DataBindingUtil.inflate(inflate, R.layout.act_login_banner_adapter, parent, false);

        return new ViewHolder(contentView/*,null*/);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivPhopt;
        ImageView ivDelete;

        ViewHolder(View view/*, ActLoginBannerAdapterBinding mBinding*/) {
            super(view);

        }
    }
    public  interface onChildListener{
        void onChildListener(View view, int position);
    }
}