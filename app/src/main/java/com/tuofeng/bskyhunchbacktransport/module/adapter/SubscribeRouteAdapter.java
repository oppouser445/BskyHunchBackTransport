package com.tuofeng.bskyhunchbacktransport.module.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;

import java.util.List;

public class SubscribeRouteAdapter extends RecyclerView.Adapter<SubscribeRouteAdapter.ViewHolder> {

    private List<String> mList;
    private Context mContext;
    private RecycleBannerAdapter.onChildListener onChildListener;
    private MyOnClickListener mClickListener;

    public SubscribeRouteAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(mContext);
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_test_item,parent,false)
        View contentView = inflate.inflate(R.layout.subscribe_route_list_layout, parent, false);
        //mBinding = DataBindingUtil.inflate(inflate, R.layout.act_login_banner_adapter, parent, false);
        return new ViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mLlyaoutHome;

        ViewHolder(View view/*, ActLoginBannerAdapterBinding mBinding*/) {
            super(view);
            mLlyaoutHome = view.findViewById(R.id.llyaout_home);
        }
    }

    public void setMyOnClickListener(MyOnClickListener clickListener) {
        mClickListener = clickListener;
    }

    public interface MyOnClickListener {
        void onItemClick(int position);
    }
}