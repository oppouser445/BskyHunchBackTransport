package com.tuofeng.bskyhunchbacktransport.ui.view.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuofeng.bskyhunchbacktransport.R;
import com.tuofeng.bskyhunchbacktransport.module.adapter.ImageListAdpter;
import com.tuofeng.bskyhunchbacktransport.ui.view.SharedButton;

public class LoadingDepartureDialog extends BaseDialog {


    private RecyclerView mRecyclerImage;
    private SharedButton mBtnFc;

    public LoadingDepartureDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.loadingdeparture_dialog_layout;
    }

    @Override
    protected void initView() {
        mRecyclerImage = findViewById(R.id.recycler_image);
        mBtnFc = findViewById(R.id.btn_fc);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        mRecyclerImage.setLayoutManager(gridLayoutManager);

        /*ImageListAdpter photosListAdpter = new ImageListAdpter(mContext, images);
        mRecyclerImage.setLayoutManager(gridLayoutManager);
        mRecyclerImage.setAdapter(photosListAdpter);*/

        mBtnFc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick("");
                dismiss();
            }
        });
    }

    @Override
    public void initWindow() {
        super.initWindow();
        mWindow.setGravity(Gravity.BOTTOM);
    }

    private MyClicklListener mListener;

    public void setMyClickListener(MyClicklListener listener) {
        this.mListener = listener;
    }

    public interface MyClicklListener {
        void onClick(String data);
    }
}