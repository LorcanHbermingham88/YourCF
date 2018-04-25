package com.example.lorcan.yourcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodFacts extends AppCompatActivity {

    Button btnProtien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_facts);

        btnProtien = (Button)findViewById(R.id.button2);

        btnProtien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(FoodFacts.this,Protein.class);
                startActivity(signUp);
            }
        });
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(FoodFacts.this, MainActivity.class));
        finish();
    }
}

