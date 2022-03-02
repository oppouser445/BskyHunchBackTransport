package com.tuofeng.bskyhunchbacktransport.module.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;

import java.util.List;

public class FleetManagementAdapter extends RecyclerView.Adapter<FleetManagementAdapter.ViewHolder> {
    private List<String> mList;
    private Context mContext;
    private onChildListener onChildListener;
    //private ActLoginBannerAdapterBinding mBinding;

    public FleetManagementAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(mContext);

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_test_item,parent,false)
        View contentView = inflate.inflate(R.layout.item_fleet_management_list, parent, false);
        //mBinding = DataBindingUtil.inflate(inflate, R.layout.act_login_banner_adapter, parent, false);
        return new ViewHolder(contentView/*,null*/);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        /*holder.mRlDriverInformation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onChildListener.onChildListener(v,position);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return 16;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mRlDriverInformation;

        ViewHolder(View view/*, ActLoginBannerAdapterBinding mBinding*/) {
            super(view);
            mRlDriverInformation = view.findViewById(R.id.rl_driver_information);
        }
    }

    public interface onChildListener {
        void onChildListener(View view, int position);
    }

    public void setOnChildListener(FleetManagementAdapter.onChildListener onChildListener) {
        this.onChildListener = onChildListener;
    }
}