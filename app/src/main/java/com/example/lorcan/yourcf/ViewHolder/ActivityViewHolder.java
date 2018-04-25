package com.example.lorcan.yourcf.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lorcan.yourcf.Interface.ItemClickListener;
import com.example.lorcan.yourcf.R;

/**
 * Created by lorcan on 04/04/18.
 */

public class ActivityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView activity_name;
    public ImageView activity_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ActivityViewHolder(View itemView) {
        super(itemView);

        activity_name = (TextView)itemView.findViewById(R.id.activity_name);
        activity_image = (ImageView)itemView.findViewById(R.id.activity_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }

}
