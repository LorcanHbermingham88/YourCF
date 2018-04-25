package com.example.lorcan.yourcf;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lorcan.yourcf.Model.Spirometer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SpirometerTest extends AppCompatActivity {

    MaterialEditText edtDate, edtSpiroResult,edtSpiroResult1,edtSpiroResult2;
    TextView edtStopWatch;
    Button btnSubmit, btnStart, btnStop;
    Handler customhandler = new Handler();

    long startTime=0L,timeInMilliseconds=0L,timeSwapBuff=0L,updateTime=0L;

    Runnable updateTimeThread = new Runnable() {
        @Override
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis()-startTime;
            updateTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int)(updateTime/1000);
            int mins=secs/60;
            secs%=60;
            int milliseconds=(int)(updateTime%1000);
            edtStopWatch.setText(""+mins+":"+String.format("%2d",secs)+":"+String.format("%3d",milliseconds));
            customhandler.postDelayed(this,0);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spirometer);

        edtDate = (MaterialEditText)findViewById(R.id.edtDate);
        edtStopWatch = (TextView) findViewById(R.id.edtStopWatch);
        edtSpiroResult = (MaterialEditText)findViewById(R.id.edtSpiroResult);
        edtSpiroResult1 = (MaterialEditText)findViewById(R.id.edtSpiroResult1);
        edtSpiroResult2 = (MaterialEditText)findViewById(R.id.edtSpiroResult2);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnStop);

        // init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_Spirometer = database.getReference("Spirometer");

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startTime = SystemClock.uptimeMillis();

                customhandler.postDelayed(updateTimeThread,0);

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeSwapBuff+=timeInMilliseconds;
                customhandler.removeCallbacks(updateTimeThread);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(SpirometerTest.this);
                mDialog.setMessage("Please Wait....");
                mDialog.show();

                table_Spirometer.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // check if number already exists
                        if(dataSnapshot.child(edtDate.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(SpirometerTest.this, "Date Has Already Been Entered!!!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            //total+=(Integer.parseInt(selection.getCalorieAmount()))*(Integer.parseInt(selection.getQuantity()));
                            Spirometer spiro = new Spirometer(edtStopWatch.getText().toString(),edtSpiroResult.getText().toString());
                            Spirometer spiro1 = new Spirometer(edtStopWatch.getText().toString(),edtSpiroResult1.getText().toString());
                            Spirometer spiro4 = new Spirometer(edtStopWatch.getText().toString(),edtSpiroResult2.getText().toString());
                            int spiro3 = Integer.parseInt(spiro.getSpirometerResult()) + (Integer.parseInt(spiro1.getSpirometerResult()) + (Integer.parseInt(spiro4.getSpirometerResult())));
                            //Spirometer result = Integer.parseInt(spiro3.getSpirometerResult());
                            int result = spiro3/3;
                            Spirometer test = new Spirometer(edtStopWatch.getText().toString(),String.valueOf(result));
                            table_Spirometer.child(edtDate.getText().toString()).setValue(test);
                            Toast.makeText(SpirometerTest.this, "Test Recorded", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(SpirometerTest.this,Home.class);
                            startActivity(homeIntent);
                            //finish();
                        }

                    }



                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(SpirometerTest.this, Home.class));
        finish();
    }
}
