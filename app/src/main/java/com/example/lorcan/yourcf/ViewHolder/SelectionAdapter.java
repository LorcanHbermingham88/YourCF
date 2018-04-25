package com.example.lorcan.yourcf.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.lorcan.yourcf.Diary;
import com.example.lorcan.yourcf.Interface.ItemClickListener;
import com.example.lorcan.yourcf.Model.Selection;
import com.example.lorcan.yourcf.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class SelectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView selection_item_name,selection_item_cal;
    public ImageView selection_item_count;

    private ItemClickListener itemClickListener;

    public void setSelection_item_name(TextView selection_item_name) {
        this.selection_item_name = selection_item_name;
    }

    public SelectionViewHolder(View itemView) {
        super(itemView);
        selection_item_name = (TextView)itemView.findViewById(R.id.selection_item_name);
        selection_item_cal = (TextView)itemView.findViewById(R.id.selection_item_cal);
        selection_item_count = (ImageView)itemView.findViewById(R.id.selection_item_count);



    }

    @Override
    public void onClick(View view) {

    }
}

public class SelectionAdapter extends RecyclerView.Adapter<SelectionViewHolder>  {

    private List<Selection> listDate = new ArrayList<>();
    private Context context;

    public SelectionAdapter(List<Selection> listDate, Diary diary) {
    }

    @Override
    public SelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.selection_layout,parent,false);
        return new SelectionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SelectionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listDate.size();
    }
}
