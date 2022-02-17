package com.tuofeng.bskyhunchbacktransport.module.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tuofeng.bskyhunchbacktransport.R;

import java.util.List;

public class ImageListAdpter extends RecyclerView.Adapter<ImageListAdpter.VH> {

    private List<String> mPhotosList;
    private Context mContext;
    private String TAG = "EnterPhotosListAdpter";

    public ImageListAdpter(Context context, List<String> mPhotosList) {
        this.mContext = context;
        this.mPhotosList = mPhotosList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View contentView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_image_list_item_layout, viewGroup, false);
        VH vh = new VH(contentView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        if (mPhotosList.size() > 0) {
            /*String string = Config.mPickUpPhotoUrl + mPhotosList.get(i);
            Glide.with(mContext)
                    .load(string)
                    .centerCrop()
                    .into(vh.imageview_enter_photosview);*/
        }
    }

    @Override
    public int getItemCount() {
        int size = mPhotosList.size();
        if (size > 3) {
            size = 3;
        }
        return size;
    }

    class VH extends RecyclerView.ViewHolder {
        private ImageView imageview_enter_photosview;

        private VH(View itemView) {
            super(itemView);
            imageview_enter_photosview = itemView.findViewById(R.id.image_enter_cancel);
        }
    }
}
