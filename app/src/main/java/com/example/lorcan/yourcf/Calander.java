package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Calander extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Calander.this, Home.class));
        finish();
    }
}
