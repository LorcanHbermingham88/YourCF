package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lorcan.yourcf.Interface.ItemClickListener;
import com.example.lorcan.yourcf.Model.ActivityType;
import com.example.lorcan.yourcf.Model.Food;
import com.example.lorcan.yourcf.ViewHolder.ActivityViewHolder;
import com.example.lorcan.yourcf.ViewHolder.FoodViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ActivityList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference activityList;

    String ActivityCategoryId="";

    FirebaseRecyclerAdapter<ActivityType,ActivityViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // firebase

        database = FirebaseDatabase.getInstance();
        activityList = database.getReference("ActivityType");

        recyclerView = (RecyclerView)findViewById(R.id.recyler_activity);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() != null){
            ActivityCategoryId = getIntent().getStringExtra("CategoryId");
        }
        if(!ActivityCategoryId.isEmpty() &&ActivityCategoryId != null){
            loadActivityList(ActivityCategoryId);
        }


    }

    private void loadActivityList(String ActivityCategoryId) {

        adapter = new FirebaseRecyclerAdapter<ActivityType, ActivityViewHolder>(ActivityType.class,R.layout.activity_item,ActivityViewHolder.class,activityList.orderByChild("ActivityMenuId").equalTo(ActivityCategoryId)) {
            @Override
            protected void populateViewHolder(ActivityViewHolder viewHolder, ActivityType model, int position) {

                viewHolder.activity_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.activity_image);

                final ActivityType local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //start new activity
                        Intent activityDetail = new Intent(ActivityList.this,ActivityDetail.class);
                        activityDetail.putExtra("ActivityId",adapter.getRef(position).getKey());
                        startActivity(activityDetail);

                        //Toast.makeText(FoodList.this, ""+local.getName(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);

    }
}
