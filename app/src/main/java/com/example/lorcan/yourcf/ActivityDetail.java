package com.example.lorcan.yourcf;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.lorcan.yourcf.Model.ActivityType;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ActivityDetail extends AppCompatActivity {

    TextView activity_name, intensity_of_activity,activity_description;
    ImageView activity_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ElegantNumberButton activityNumberButton;
    FloatingActionButton btn_activity;



    String activityId="";

    ActivityType active1;

    FirebaseDatabase database;
    DatabaseReference activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //firebase
        database = FirebaseDatabase.getInstance();
        activity = database.getReference("ActivityType");

        //init
        activityNumberButton = (ElegantNumberButton)findViewById(R.id.activity_number_button);
        btn_activity = (FloatingActionButton)findViewById(R.id.btn_activity);

        /*btn_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*new Database(getBaseContext()).addToSelection(new Selection(
                        foodId,
                        currentFood.getName(),
                        numberButton.getNumber(),
                        currentFood.getCal(), // make sure that they are the correct way around!!!
                        currentFood.getOverallCalAmount()

                ));

                int active = Integer.parseInt(activityNumberButton.getNumber()) * Integer.parseInt(active1.getIntensityOfActivity());

                Toast.makeText(ActivityDetail.this, "Food" + active, Toast.LENGTH_SHORT).show();
            }
        });*/

        /*btn_activity.setOnClickListener((view){


                int active = Integer.parseInt(activityNumberButton.getNumber()) * Integer.parseInt(active1.getIntensityOfActivity());

                Toast.makeText(ActivityDetail.this, "Food" + active, Toast.LENGTH_SHORT).show();

        });*/

        /**/

        activity_name = (TextView)findViewById(R.id.activity_name);
        intensity_of_activity = (TextView)findViewById(R.id.intensity_of_activity);
        activity_description = (TextView)findViewById(R.id.activity_description);
        //activity_image = (ImageView)findViewById(R.id.activity_image);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);
        
        //get activity id from intent 
        if(getIntent()!= null)
        {
            activityId = getIntent().getStringExtra("ActivityId");
        }
        if(!activityId.isEmpty())
        {
            getDetailActivity(activityId);
        }

    }



    private void getDetailActivity(String activityId) {
        activity.child(activityId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ActivityType active = dataSnapshot.getValue(ActivityType.class);

                //set image
                //Picasso.with(getBaseContext()).load(active.getImage()).into(activity_image);

                collapsingToolbarLayout.setTitle(active.getName());

                intensity_of_activity.setText(active.getIntensityOfActivity());

                activity_name.setText(active.getName());

                activity_description.setText(active.getAbout());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
